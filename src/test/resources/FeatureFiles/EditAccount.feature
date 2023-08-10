Feature: Edit Account functionality scenarios

  @EditAccount
  Scenario Outline: Verify whether the user is able to login with valid credentials
    Given I launch the application
    And I navigate to the Login page and I login to account and I navigate to the Edit Account page
    When I submit the account edit form with new details with "<type>" (firstName "<firstName>", lastName "<lastName>", email "<email>", telephone "<telephone>"
    Then If edit success Navigate to Login page and show a success message, else I should see message firstName error "<type>"
    Examples:
      | type             | firstName   | lastName               | telephone     | email |
      | valid            | nam         | ho                     | 01235561231   |  chuoineba2k1@gmail.com     |
      | invalidFirstName|             | ho                     | 01235561231   |       |
      | invalidFirstName| qweqweqweqwueyiquwyeiyqwiueyiqwyeiqywiuqwequwyeiyqwieyieyqiuweyqeyqwi| ho                     | 01235561231   |       |
      | invalidFirstName| ho123       | ho                     | 01235561231   |       |
      | invalidFirstName| ho@@        | ho                     | 01235561231   |       |

      | invalidLastName | nam         |                        | 01235561231   |       |
      | invalidLastName | nam         | ho123                  | 01235561231   |       |
      | invalidLastName | nam         | ho@                    | 01235561231   |       |
      | invalidLastName | nam         | hoaisudoiuasquwyeiuyqweyqiuyweiuyqwieyiquqwiueyiuqwyeiyqiwyeiyqiuwyei       | 01235561231   |       |

      | invalidEmail    | nam         |                        | 01235561231   |       |
      | invalidEmail    | nam         | hoaisudoiuasquwyeiuyqweyqiuyweiuyqwieyiquqwiueyiuqwyeiyqiwyeiyqiuwyei@gmail.com       | 01235561231   |nmbzxnbznxbznbxnzbxnbznxbznbxmnbzmnxbnbZNxVcnbvzxnbvZNxbvNZBXvnBVZxnbvZNBXvNBZVXnBVZNXbvNZXvnVZXnBV@gmail.com|
      | invalidEmail    | nam         |                        | 01235561231   |       |
      | invalidTelephone| nam         | ho                     |               |       |
      | invalidTelephone| nam         | ho                     | 012           |       |
      | invalidTelephone| nam         | ho                     | 012123761827638162836718263816283761782736817263816283618236178623   |       |

      | alreadyEmail            | nam         | ho                     | 01235561231   |   namho@gmail.com    |



