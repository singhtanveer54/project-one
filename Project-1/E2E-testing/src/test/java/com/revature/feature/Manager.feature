Feature: Manager
  Scenario: Reimbursement already approved
    Given I am the manager homepage
    When I type in a user id of "2"
    And I type in a status of "Approve"
    And I click the submit button
    Then I should see a error message of "Reimbursement already been approved"

  Scenario: All reimbursement check
    Given I am the manager homepage
    When I click the all reimbursement button
    Then I should be redirected to the all reimbursement page

  Scenario: Logout manager
    Given I am the manager homepage
    When I click the logout button
    Then I should be redirected to the login page

  Scenario: All pending reimbursement check
    Given I am the manager homepage
    When I click the pending reimbursement button
    Then I should be redirected to the pending reimbursement page


