Feature: Register functionality scenarios

  @Register @Valid
  Scenario Outline: Verify whether the user is able to register with valid credentials
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then The registration is successful and the user is redirected to the success page.
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam | ho  | anhnam.ho2@gmail.com | 01235561231 | anhnam123 | anhnam123 |true|

  @Register @firstNameInvalid
  Scenario Outline: Verify whether the user is able to register with blank firstName or invalid firstName
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a firstName error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      |  | ho  | anhnam.ho@gmail.com | 01235561231 | anhnam123 | anhnam123 |true|
      | @123 | ho  | anhnam.ho@gmail.com | 01235561231 | anhnam123 | anhnam123 |true|

  @Register @lastNameInvalid
  Scenario Outline: Verify whether the user is able to register with blank lastName or invalid lastName
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a lastName error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | @123  | anhnam.ho@gmail.com | 01235561231 | anhnam123 | anhnam123 |true|
      | @nam |   | anhnam.ho@gmail.com | 01235561231 | anhnam123 | anhnam123 |true|

  @Register @emailInvalid
  Scenario Outline: Verify whether the user is able to register with blank email or invalid email
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a email error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | ho  |  | 01235561231 | anhnam123 | anhnam123 |true|
      | nam  | ho  | namho@ | 01235561231 | anhnam123 | anhnam123 |true|

  @Register @telephoneInvalid
  Scenario Outline: Verify whether the user is able to register with blank telephone or invalid telephone
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a telephone error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | ho  |chuoito123@gmail.com  |  | anhnam123 | anhnam123 |true|
      | nam  | ho  |chuoto@gmail.com  | 123ads | anhnam123 | anhnam123 |true|
      | nam  | ho  |chuoto@gmail.com  | 123 | anhnam123 | anhnam123 |true|

  @Register @passwordInValid
  Scenario Outline: Verify whether the user is able to register with blank passwordInValid or invalid passwordInValid
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a passwordInValid error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | ho  |chuoto@gmail.com  | 0123461523 | | anhnam123 |true|
      | nam  | ho  |chuoto@gmail.com  | 0123461523 | abc | anhnam123 |true|

  @Register @confirmPasswordInValid
  Scenario Outline: Verify whether the user is able to register with blank confirmPasswordInValid or invalid confirmPasswordInValid
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a confirmPasswordInValid error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | ho  |chuoto@gmail.com  | 0123461523 | anhnam12 | anhnam123 |true|
      | nam  | ho  |chuoto@gmail.com  | 0123461523 | | anhnam123 |true|

  @Register @checkPolicy
  Scenario Outline: Verify whether the user is able to register with uncheck accept check policy
    Given I launch the application
    And I navigate to register page
    When Enter information for all required fields (First Name "<firstName>", Last Name "<lastName>", Email "<email>", Telephone "<telephone>", Password "<password>", Confirm Password "<confirmPassword>", checkbox "<checkbox>")
    Then I should see a policy error message that the credentials invalid
    Examples:
      | firstName | lastName  | email | telephone | password | confirmPassword | checkbox |
      | nam  | ho  |chuoto@gmail.com  | 0123461523 | anhnam12 | anhnam123 |false|













