require('dotenv').config();

async function login(page) {

    await page.goto(
        'https://eventhub.rahulshettyacademy.com/login'
    );

    await page
        .getByPlaceholder('you@email.com')
        .fill(process.env.EVENTHUB_EMAIL);

    await page
        .getByLabel('Password')
        .fill(process.env.EVENTHUB_PASSWORD);

    await page
        .locator('#login-btn')
        .click();
}

module.exports = { login };