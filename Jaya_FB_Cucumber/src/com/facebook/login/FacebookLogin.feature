Feature: Facebook Login
#In order to validate the correct user login and display of inbox

Scenario Outline:Login with different user ids and passwords and see if the inbox is displayed 
	Given I go to URL
	And I enter "email" as <emailId> 
	And I enter "pass" as <password>
	And click on "loginbutton"
	Then inbox page is displayed
	
	
Examples:
|emailId|password|
|"jayav.2007@gmail.com"|"jackiechan"|
|"jayav.2007@gmail.com"|"dsiahdias"|