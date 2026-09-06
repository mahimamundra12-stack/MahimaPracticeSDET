const { test, expect, request } = require('@playwright/test');

const loginPayLoad = {
  userEmail: "mahimamundra.12@gmail.com",
  userPassword: "LearningPlaywright@1"
};

const orderPayLoad = {orders: [[
    {
        country: "India",
        productOrderedId: "6960eae1c941646b7a8b3ed3"
    }
]]}

let token;

test.beforeAll(async () => {
  const apiContext = await request.newContext();

  const loginResponse = await apiContext.post(
    "https://rahulshettyacademy.com/api/ecom/auth/login",
    { data: loginPayLoad }
  );

  expect(loginResponse.ok()).toBeTruthy();

  const loginResponseJson = await loginResponse.json();
  token = loginResponseJson.token;

  console.log("Token:", token);


const OrderResponse = await apiContext.post(
    "https://rahulshettyacademy.com/api/ecom/order/create-order",
    { data: orderPayLoad, headers: { authorization: token } }
  )
  const OrderResponseJson = await OrderResponse.json();
  console.log("Order Response:", OrderResponseJson);
  orderId = OrderResponseJson.orders[0];


});

test.beforeEach(() => {})

test("retrieve authentication token", async () => {
  expect(token).toBeTruthy();
});