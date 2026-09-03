const fs = require('fs');
const html = fs.readFileSync('index.html', 'utf8');

// Find where allStories is defined. It's a global array.
const startIdx = html.indexOf('const allStories = [');
const endIdx = html.indexOf('let currentStory = allStories[0];');
const arrayStr = html.substring(startIdx + 'const allStories = '.length, endIdx).trim().replace(/;$/, '');
const allStories = eval(arrayStr);

const regex = /\[(L|T|C|N|ADJ|ADV|P|S)(?::([^:\]]+))?(?::([^\]]+))?\]\(([^)]+)\)/g;

for (const story of allStories) {
  let parsedTokens = [];
  let fullPlainString = "";
  let lastIndex = 0;
  let match;
  
  const rawText = story.raw;
  
  while ((match = regex.exec(rawText)) !== null) {
    if (match.index > lastIndex) {
      const chunk = rawText.substring(lastIndex, match.index);
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
          parsedTokens.push({
            type: 'TEXT',
            text: part,
            charStart: start,
            charEnd: end
          });
        }
      }
    }
    const [_, tagType, p1, p2, info] = match;
    const word = (p2 && p2.trim()) ? p2.trim() : (p1 ? p1.trim() : "");
    const extra = (p2 && p2.trim()) ? p1.trim() : "";
    const start = fullPlainString.length;
    fullPlainString += word;
    const end = fullPlainString.length;
    parsedTokens.push({
      type: tagType,
      text: word,
      info: info.trim(),
      extra: extra,
      charStart: start,
      charEnd: end
    });
    lastIndex = regex.lastIndex;
  }
}
console.log("ALL GOOD");
