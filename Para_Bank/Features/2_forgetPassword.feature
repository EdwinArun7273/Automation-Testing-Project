@forgetPassword

Feature: Forget Password Page


Scenario: Verify the reset password functionality with valid details
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays username and password
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|qwe			|rty		|uio		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid first name
Given the user is in the reset password page
When he enters invalid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message for invalid firstname
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|abcdefg		|user1ln		|qwe			|rty		|uio		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid last name
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and invalid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message  for invalid lastname
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|hijklmn		|qwe			|rty		|uio		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid address
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and invalid address "<address>" and valid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message for invalid address
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|zzz			|rty		|uio		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid city name
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and invalid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message for invalid city name
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|qwe			|yyy		|uio		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid state
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and invalid state "<state>" and valid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message for invalid state
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|qwe			|rty		|aaa		|123456     |54323456789 	|


Scenario: Verify the reset password functionality with invalid zip code
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and valid state "<state>" and invalid zipcode "<zipcode>" and valid ssn "<ssn>"
Then system displays error message for invalid zip code
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|qwe			|yyy		|uio		|000000     |54323456789 	|


Scenario: Verify the reset password functionality with invalid ssn
Given the user is in the reset password page
When he enters valid firstname "<firstname>" and valid lastname "<lastname>" and valid address "<address>" and valid city "<city>" and valid state "<state>" and valid zipcode "<zipcode>" and invalid ssn "<ssn>"
Then system displays error message for invalid ssn
Examples:
|firstname		|lastname		|address		|city		|state		|zipcode	|ssn			|
|user1fn		|user1ln		|qwe			|rty		|uio		|123456     |0000000000 	|