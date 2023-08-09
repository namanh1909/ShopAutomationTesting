Feature: Register functionality scenarios

  @Register
  Scenario Outline: Verify whether the user is able to register with valid credentials or invalid credentials
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<type>" "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then If register success, navigate to account page and show message. Else show error message "<type>"
    Examples:
      | type            | firstName   | lastName               | telephone     | password    | confirmPassword | checkbox | email |
      | valid           | nam         | ho                     | 01235561231   | anhnam123   | anhnam123       | true     |       |

      | invalidFirstName |             | ho                     | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidFirstName | qweqweqweqwueyiquwyeiyqwiueyiqwyeiqywiuqwequwyeiyqwieyieyqiuweyqeyqwi| ho                     | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidFirstName | ho123       | ho                     | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidFirstName | ho@@        | ho                     | 01235561231   | anhnam123   | anhnam123       | true     ||

      | invalidLastName | nam          |                        | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidLastName | nam          | ho123                  | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidLastName | nam          | ho@                    | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidLastName | nam          | hoaisudoiuasquwyeiuyqweyqiuyweiuyqwieyiquqwiueyiuqwyeiyqiwyeiyqiuwyei       | 01235561231   | anhnam123   | anhnam123       | true     ||

      | invalidEmail | nam          |                        | 01235561231   | anhnam123   | anhnam123       | true     ||
      | invalidEmail | nam          | hoaisudoiuasquwyeiuyqweyqiuyweiuyqwieyiquqwiueyiuqwyeiyqiwyeiyqiuwyei@gmail.com       | 01235561231   | anhnam123   | anhnam123       | true     |nmbzxnbznxbznbxnzbxnbznxbznbxmnbzmnxbnbZNxVcnbvzxnbvZNxbvNZBXvnBVZxnbvZNBXvNBZVXnBVZNXbvNZXvnVZXnBV@gmail.com|
      | invalidEmail | nam          |                        | 01235561231   | anhnam123   | anhnam123       | true     ||

      | invalidTelephone           | nam         | ho                     |    | anhnam123   | anhnam123       | true     ||
      | invalidTelephone           | nam         | ho                     |  012   | anhnam123   | anhnam123       | true     ||
      | invalidTelephone           | nam         | ho                     |  012123761827638162836718263816283761782736817263816283618236178623   | anhnam123   | anhnam123       | true     ||

      | invalidPassword           | nam         | ho                     | 01235561231   |    | anhnam123       | true     |       |
      | invalidPassword           | nam         | ho                     | 01235561231   | 123   | anhnam123       | true     |       |
      | invalidPassword           | nam         | ho                     | 01235561231   | 12316283681628687162836178263812638617823616236   | anhnam123       | true     |       |

      | invalidConfirmPassword           | nam         | ho                     | 01235561231   | anhnam123   | anhnam12      | true     |       |

      | dontCheck           | nam         | ho                     | 01235561231   | anhnam123   | anhnam123       | false     |       |

      | alreadyEmail           | nam         | ho                     | 01235561231   | anhnam123   | anhnam123       | true     | chuoineba2k1@gmail.com      |














