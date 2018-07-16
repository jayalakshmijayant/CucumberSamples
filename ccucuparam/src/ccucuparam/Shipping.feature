Feature: Cucumber Parameterization
#In order to validate the shipping details page

Scenario Outline:Show and validate shipping details 
	Given URL is loaded successfully
	When page loads check for shipping details tag and <shipmentID> as link and click the link
	Then validate <custName> is displayed on page
Examples:
|shipmentID|custName|
|"6543217" |"Maya"  |
	

	