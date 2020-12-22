Feature: Place Addition

Scenario Outline: post data

Given user provides the get api
When user call the get place "<api>" with get and "<placeid>" http request
Then  Api call got success with status code 200
And "accuracy" in response body is "50"

Examples:
|api                           |                         placeid|
|maps/api/place/get/json       |f5e6931b33bcd33108195737ef3b5f0b|
|maps/api/place/get/json       |849900e30bdd117357048802edaa8067|
|maps/api/place/get/json       |a8b83d6ff2137fe035fd80f1691047fa|

