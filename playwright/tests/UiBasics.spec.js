const {test} = require('@playwright/test');

test('basic test', async({browser}) => {
  const context = await browser.newContext();
  const page = await context.newPage();
  await page.goto('https://playwright.dev/');
  await page.screenshot({path: `example.png`});
 
});