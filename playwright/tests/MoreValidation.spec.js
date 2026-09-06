const {test,expect}= require('@playwright/test');

test("popup validation", async ({page})=>{ 

    await page.goto("https://rahulshettyacademy.com/AutomationPractice/");
    // await page.goto("https://google.com");
    // await page.goBack();
   // await page.goForward();
    await expect(page.locator("#displayed-text")).toBeVisible();
    await page.locator("#hide-textbox").click();
    await expect(page.locator("#displayed-text")).toBeHidden();
    // await page.locator("#show-textbox").click();
    // await expect(page.locator("#displayed-text")).toBeVisible();
    page.pause();
    page.on('dialog', dialog => dialog.accept());
    await page.locator("#confirmbtn").click();
    await page.locator("#mousehover").hover();
    const framepage = page.frameLocator("#courses-iframe");
    //framepage.locator("li a[href*='lifetime-access']:visible").click();

 })