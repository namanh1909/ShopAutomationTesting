Feature: Login functionality scenarios

  @Login @Valid
  Scenario: Verify whether the user is able to login with valid credentials
    Given I launch the application
    And I navigate to Login page
    When I login to the Application using Username "chuoineba2k1@gmail.com" and Password "anhnam123"
    Then I should see that the user is able to login successfully

  @Login @Invalid
  Scenario Outline: Verify whether the user is not able to login with invalid credentials
    Given I launch the application
    And I navigate to Login page
    When I login to the Application using Username "<email>" and Password "<password>"
    Then I should see a error message that the credentials invalid
    Examples:
      | email                  | password  |
      |  | Wrong@123 |
      | qwyiuqwyeiuyqwiueyiquwyieyqiwyeiqywieyiqwyeiqywiueyqiwyeisgi@gmail.com | Wrong@123|
      | ho nam@gmail.com | Wrong@123 |
      | namho@g | Wrong@123 |

      | namho@gmail.com |  |
      | namho@gmail.com | asdasdasgdqtwjggasjhdghjasgdjhagsjhdgajhsgdajgsdhjvqwjvdnabvsndvasduiqw |
      | namho@gmail.com | 125 |
      |namhhh22o@gmail.com | anhnam123|












