const https = require('https');
https.get('https://api.dictionaryapi.dev/api/v2/entries/en/magic', (res) => {
  let data = '';
  res.on('data', (chunk) => data += chunk);
  res.on('end', () => console.log(data.substring(0, 500)));
});
