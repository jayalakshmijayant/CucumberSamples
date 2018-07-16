Feature: Cucumber Datatables
#To show shipping details of user

Scenario: Show shipping details of various users
	Given the URL is loaded successfully to launch applcation
	When I enter "Shamili" and click search button
	Then following details should be displayed
	|Name     |Shipment Id|Phone Number|E-mail               |
	|Shamili  |SHIP1236   |9224158877  |shamili93@gamil.com  |