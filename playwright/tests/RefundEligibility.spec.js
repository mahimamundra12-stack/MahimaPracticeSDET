const { test, expect } = require('@playwright/test');
const { login } = require('../utils/auth');

const BASE_URL = 'https://eventhub.rahulshettyacademy.com';

async function loginAndGoToBooking(page) {
    await login(page);

    await expect(page.getByRole('link', { name: 'Browse Events →' })).toBeVisible();
}

test('Refund eligible for single ticket booking', async ({ page }) => {
    // Step 1 - Login
    await loginAndGoToBooking(page);

    // Step 2 - Navigate to Events
    await page.goto(`${BASE_URL}/events`);

    await page.getByTestId('event-card').first().getByTestId('book-now-btn').click();

    await page.getByLabel('Full Name').fill('Test User');
    await page.locator('#customer-email').fill(process.env.EVENTHUB_EMAIL);
    await page.getByPlaceholder('+91 98765 43210').fill('9876543210');

    await page.locator('.confirm-booking-btn').click();
    await page.getByRole('link', { name: 'View My Bookings' }).click();
    await expect(page).toHaveURL(`${BASE_URL}/bookings`);
    await page.getByRole('link', { name: 'View Details' }).first().click();
    await expect(page.getByText('Booking Information')).toBeVisible();

    const bookingRef = (await page.locator('span.font-mono.font-bold').innerText()).trim();
    const eventTitle = (await page.locator('h1').innerText()).trim();

    console.log('Booking Reference:', bookingRef);
    console.log('Event Title:', eventTitle);
    expect(bookingRef.charAt(0)).toBe(eventTitle.charAt(0));

    await page.locator('#check-refund-btn').click();
    await expect(page.locator('#refund-spinner')).toBeVisible();
    await expect(page.locator('#refund-spinner')).not.toBeVisible({ timeout: 6000 });

    const result = page.locator('#refund-result');
    await expect(result).toBeVisible();
    await expect(result).toContainText('Eligible for refund.');
    await expect(result).toContainText(' Single-ticket bookings qualify for a full refund.');
    await expect(result).toContainText('Single-ticket bookings qualify for a full refund.');
});

test('Refund not eligible for multiple ticket booking', async ({ page }) => {
    await loginAndGoToBooking(page);
    await page.goto(`${BASE_URL}/events`);
    await page.getByTestId('event-card').first().getByTestId('book-now-btn').click();
    await page.locator('button:has-text("+")').click();
    await page.locator('button:has-text("+")').click();
    await expect(page.locator('#ticket-count')).toHaveText('3');
    await page.getByLabel('Full Name').fill('Test User');
    await page.locator('#customer-email').fill(process.env.EVENTHUB_EMAIL);
    await page.getByPlaceholder('+91 98765 43210').fill('9999999999');
    await page.locator('.confirm-booking-btn')
        .click();
    const bookingReference = page.locator('.booking-ref').first();
    await expect(bookingReference).toBeVisible();

    const bookingRef = (await bookingReference.innerText()).trim();

    console.log('3-ticket Booking Reference:', bookingRef);
    await page.getByRole('link', { name: 'View My Bookings' }).click();
    await expect(page).toHaveURL(`${BASE_URL}/bookings`);

    const myBooking = page.getByTestId('booking-card').filter({ has: page.locator('.booking-ref', { hasText: bookingRef }) });
    await myBooking.getByRole('link', { name: 'View Details' }).click();
    await expect(page.getByText('Booking Information')).toBeVisible();

    const bookingRefOnDetails = await page.locator('span.booking-ref').innerText();
    const eventTitle = await page.locator('h1').innerText();

    expect(bookingRefOnDetails.charAt(0)).toBe(eventTitle.charAt(0));

    await page.locator('#check-refund-btn').click();
    await expect(page.locator('#refund-spinner')).toBeVisible();
    await expect(page.locator('#refund-spinner')).not.toBeVisible({ timeout: 6000 });

    const result = page.locator('#refund-result');
    await expect(result).toBeVisible();
    await expect(result).toContainText('Not eligible for refund');
    await expect(result).toContainText('Group bookings (3 tickets) are non-refundable');
});