const { test, expect } = require('@playwright/test');
const { login } = require('../utils/auth');
const { futureDateValue } = require('../utils/date');

test('Create event and complete booking', async ({ page }) => {
  // Step 1 - Login
  await login(page);
  await expect(page.getByRole('link', { name: 'Browse Events →' })).toBeVisible();

  // Step 2 - Navigate to Browse Events
  await page.getByRole('link', { name: 'Browse Events →' }).click();
  await expect(page).toHaveURL('https://eventhub.rahulshettyacademy.com/events');

  // Step 3 - Generate event title and navigate to admin events
  const eventTitle = `Test Event ${Date.now()}`;
  console.log('Event Title:', eventTitle);
  await page.goto('https://eventhub.rahulshettyacademy.com/admin/events');

  // Step 4 - Fill event form
  await page.locator('#event-title-input').fill(eventTitle);
  await page.locator('#admin-event-form textarea').fill('Test event created using Playwright automation');
  await page.getByLabel('City').fill('Bangalore');
  await page.getByLabel('Venue').fill('Bangalore Convention Centre');
  console.log('futureDateValue type:', typeof futureDateValue);
  console.log('Future date:', futureDateValue()); 
  await page.getByLabel('Event Date & Time').fill(futureDateValue());
  await page.getByLabel('Price ($)').fill('100');
  await page.getByLabel('Total Seats').fill('50');

  // Step 5 - Submit event
  await page.locator('#add-event-btn').click();

  // Step 6 - Verify event creation
  await expect(page.getByText('Event created!')).toBeVisible();
  console.log('Event created successfully:', eventTitle);

    // Step 7 - Navigate to Browse Events and book the event
   await page.goto('https://eventhub.rahulshettyacademy.com/events');

const eventLink = page
  .getByRole('heading', { name: eventTitle, exact: true })
  .locator('..');

await expect(eventLink).toBeVisible();

// Find the event card containing our event
const eventCard = page.getByTestId('event-card').filter({
  hasText: eventTitle
});

await expect(eventCard).toBeVisible();

// Capture seats BEFORE booking
const seatText = eventCard.getByText(/\d+\s+seats?\s+available/i);

const seatsBeforeBooking = parseInt(
  await seatText.innerText()
);

console.log('Seats before booking:', seatsBeforeBooking);

await eventLink.click();

// Event details page
//await expect(page.locator('#book-now-btn')).toBeVisible();

//await page.locator('#book-now-btn').click();
//strat booking
await expect(
    page.locator('#ticket-count')
).toHaveText('1');

await page.getByLabel('Full Name')
    .fill('Mahima Maheshwari');

await page.locator('#customer-email')
    .fill(process.env.EVENTHUB_EMAIL);

await page.getByPlaceholder('+91 98765 43210')
    .fill('9876543210');

await page.locator('.confirm-booking-btn').click();


// Step 9 - Capture booking reference

const bookingReference = page.locator('.booking-ref').first();

await expect(bookingReference).toBeVisible();

const bookingRef = (await bookingReference.innerText()).trim();

console.log('Booking Reference:', bookingRef);

// Step 10 - Verify booking in My Bookings

await page
    .getByRole('link', { name: 'View My Bookings' })
    .click();

await expect(page).toHaveURL(
    'https://eventhub.rahulshettyacademy.com/bookings'
);

const bookingCards = page.locator('#booking-card');

await expect(bookingCards.first()).toBeVisible();

const myBooking = bookingCards.filter({
    has: page.locator('.booking-ref', {
        hasText: bookingRef
    })
});

await expect(myBooking).toBeVisible();

await expect(myBooking).toContainText(eventTitle);

console.log('Booking verified:', bookingRef);

//step -11 verify seats after booking
 // Step 11 - Verify seats after booking

await page.goto('https://eventhub.rahulshettyacademy.com/events');

// Find our event again
const eventCardAfter = page.getByTestId('event-card').filter({
  hasText: eventTitle
});

await expect(eventCardAfter).toBeVisible();

// Read seat count from OUR event card
const seatTextAfter = eventCardAfter.getByText(
  /\d+\s+seats?\s+available/i
);

const seatsAfterBooking = parseInt(
  await seatTextAfter.innerText()
);

//console.log('Seats before booking:', seatsBeforeBooking);
console.log('Seats after booking:', seatsAfterBooking);

// Final assertion
expect(seatsAfterBooking).toBe(
  seatsBeforeBooking - 1
);


});