Feature: Logging into Facebook

In order to open FB 
As a User
I want to login

Scenario: Logging in Facebook

Given I go to "AppURL" on "Chrome"
And I enter "loginUsername_id" as "jayav.2007@gmail.com"
And I enter "loginPassword_id" as "jackiechan"
And I click on "SigninBtn_id"
Then Login should be "successful"