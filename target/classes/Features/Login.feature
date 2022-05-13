Feature: Free CRM login feature

Scenario: Login to CRM application
	Given User is already on login page 
	When Title of login page is Free CRM 
	Then User enters Username  
	And User enters password
	And User clicks on login button
	And User adds the following contacts
	|firstname | mail id       | lastname |
	| Ani      | ani@gmail.com | Vasudev  |
	| Megh     | megh@gmail.com| Rao      |
	
	