Feature:	Find UsbFlashDrives in CustomInk
# Simple test to find USB flash drives in Tech Accessories category of Custm Ink web application.

Scenario:	verify user views USB flash drives

	Given Buyer at home page of CustomInk
	When Buyer mouse over PRODUCTS tab
	And Buyer selects Tech Accessories from dropdown
	And Buyer selects USB Flash Drives display
	And Buyer prints Drivers Displayed
	Then Buyer prints page title
