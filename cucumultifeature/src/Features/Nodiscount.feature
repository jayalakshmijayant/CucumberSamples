Feature: Validate No-discounts offered by DataX shipping company
#Multiple Features and Step Definitions

Background:
	Given the URL is launched successfully

Scenario Outline:
	When I enter weight as <Weight> and distance as <Distance> and click submit button
	Then the following text should be displayed
	|message|
	|Datax shipping offers no discount|
Examples:
	|Weight|Distance|
	|60    |110   |
	|50    |150   |
	