Feature: Signup

# " " double quotes are used as inline parameters for the actual gluecode methods. It will be passed in as arguments

Scenario: Invalid first name, valid username, valid password, valid last name, valid email, valid role  (negative test)
	Given I am at the signup page
	When I type in a username of <username>
	And I type in a password of <password>
	And I type in a first name of " "
	And I type in a last name of "Singh"
	And I type in a email of "tanveer@list.com"
	And I type in a role of "manager"
	And I click the sign up button
	Then I should see a message of "First name cannot be empty"
	
	Examples:
		| username | password |
		| "yudh45" | "password12345"  |