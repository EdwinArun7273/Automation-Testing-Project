@login

Feature: Login Page


Scenario: Verify the login functionality with valid details
Given the user is in the login page
When he enters valid username "<username>" and valid password "<password>"
Then user navigates to home page
Examples:
|username		|password		|
|user1usthp		|Pass@word123	|


Scenario: Verify the login functionality with invalid username
Given the user is in the login page
When he enters invalid username "<username>" and password "<password>"
Then system displays error message for invalid username
Examples:
|username		|password		|
|usthp7273		|Pass@word123	|


Scenario: Verify the login functionality with invalid password
Given the user is in the login page
When he enters username "<username>" and invalid password "<password>"
Then system displays error message for invalid password
Examples:
|username		|password	|
|usthp7273		|Pass@word	|


Scenario: Verify the login functionality with blank email
Given the user is in the login page
When he enters blank username "<username>" and password "<password>"
Then system displays error message for blank username
Examples:
|username		|password	|
|				|Pass@word	|


Scenario: Verify the login functionality with blank password
Given the user is in the login page
When he enters username "<username>" and blank password
Then system displays error message for blank password
Examples:
|username		|password	|
|user1usthp		|			|