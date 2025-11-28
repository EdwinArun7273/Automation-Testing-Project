@openNewAccount

Feature: Open New Account Page


Scenario: Verify the open new checking/savings account functionality
Given the user is in the open new accounts page
When he selects account type "<type>"
Then system creates a new account
Examples:
|type		|
|SAVINGS	|

Scenario: Verify the open multiple accounts account functionality
Given the user is in the open new accounts page
When he selects account type "<type>" multiple times
Then system displays error message
Examples:
|type		|
|SAVINGS	|