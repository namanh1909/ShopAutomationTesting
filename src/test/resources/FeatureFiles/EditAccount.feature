Feature: Edit Account functionality scenarios

  @EditAccount @Valid
  Scenario Outline: Verify whether the user is able to login with valid credentials
    Given I launch the application
    And I navigate to the Login page and I login to account and I navigate to the Edit Account page
    When I submit the account edit form with new details with "<type>" (firstName "<firstName>", lastName "<lastName>", email "<email>", telephone "<telephone>"
    Then If edit success Navigate to Login page and show a success message, else I should see message firstName error "<type>"
    Examples:
    | type | firstName | lastName | email | telephone |
    | valid | nam | ho2 | anaphora@gmail.com | 01231524 |



