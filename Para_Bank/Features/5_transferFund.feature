@transferFund

Feature: Check Transfer Fund


Scenario: Verify the account overview functionality
Given the user is in the transfer fund page
When user enters "<amount>" and selects transfer button
Then system displays success message
Examples:
|amount		|
|5000		|