const raw = "hello [N:world](info)";
const regex = /\[(L|T|C|N|ADJ|ADV|P|S)(?::([^:\]]+))?(?::([^\]]+))?\]\(([^)]+)\)/g;
let parsedTokens = [];
let fullPlainString = "";
let lastIndex = 0;
let match;
while ((match = regex.exec(raw)) !== null) {
  if (match.index > lastIndex) {
    const chunk = raw.substring(lastIndex, match.index);
    const subRegex = /(\s+|\S+)/g;
    let subMatch;
    while ((subMatch = subRegex.exec(chunk)) !== null) {
      const part = subMatch[0];
      if (/^\s+$/.test(part)) {
        parsedTokens.push({ type: 'WS', text: part });
        fullPlainString += part;
      } else {
        const start = fullPlainString.length;
        fullPlainString += part;
        const end = fullPlainString.length;
        parsedTokens.push({ type: 'TEXT', text: part });
      }
    }
  }
  const [_, tagType, p1, p2, info] = match;
  const word = (p2 && p2.trim()) ? p2.trim() : (p1 ? p1.trim() : "");
  parsedTokens.push({ type: tagType, text: word });
  lastIndex = regex.lastIndex;
}
console.log(parsedTokens);
