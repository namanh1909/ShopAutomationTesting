Feature: Forgot password functionality scenarios

  @forgotPassword @Valid
  Scenario: Verify whether the user is able to forgot password with valid email
    Given I launch the application
    And I navigate to Login page and then navigate to Forgot password page
    When I enter email value "namho@gmail.com" and click continue button
    Then I should see navigate to login page and have a message success send email

  @forgotPassword @Invalid
  Scenario Outline: Verify whether the user is able to forgot password with invalid email
    Given I launch the application
    And I navigate to Login page and then navigate to Forgot password page
    When I enter email value "<email>" and click continue button
    Then I should see message error invalid email
    Examples:
      | email                                                                  |
      |                                                                        |
      | qiwueoqwuoeuoqwueoiquwoeuqoweuioquweoiqywiuryquweyqiuwyeiuqe@gmail.com |
      | nam ho@gmail.com                                                       |
      | namho@com                                                              |




