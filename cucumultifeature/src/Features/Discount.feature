Feature: Validate discounts offered by DataX shipping company
#Multiple Features and Step Definitions


	
Scenario Outline:
	Given the following app is launched successfully
	|url|
	|http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/|
	When I enter weight as <Weight> and distance as <Distance> and select submit button
	Then the text <Message> should be displayed
Examples:
	|Weight|Distance|Message                                 |
	|"100" |"200"   |"Datax shipping company offers discount"|
	|"80"  |"500"   |"Datax shipping company offers discount"|
	|"120" |"520"   |"Datax shipping company offers discount"|
	|"300" |"200"   |"Datax shipping company offers discount"|