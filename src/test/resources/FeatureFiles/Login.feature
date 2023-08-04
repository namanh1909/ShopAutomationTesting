Feature: Login functionality scenarios

  @Login @One
  Scenario: Verify whether the user is able to login with valid credentials
    Given I launch the application
    And I navigate to Account Login page
    When I login to the Application using Username "chuoineba2k1@gmail.com" and Password "anhnam123"
    Then I should see that the user is able to login successfully

  @Login @Two
  Scenario Outline: Verify whether the user is not able to login with invalid credentials
    Given I launch the application
    And I navigate to Account Login page
    When I login to the Application using Username "<email>" and Password "<password>"
    Then I should see a error message that the credentials invalid
    Examples:
      | email                  | password  |
      | prashant7538@gmail.com | Wrong@123 |
      |  |  |
      | prashant7538@gmail.com |  |
      | | 123 |



