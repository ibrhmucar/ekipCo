@test
Feature: User should be able to complete successfully hire now steps

  Background:
    Given : User on the main URL

  Scenario Outline: User should be able to complete hire now step successfully
    Given : User should be able to write work mail to enter your work email space
    Then  : User should be able to click Hire Now button
    And   : User should be able to see the next page to continue to fill information
    Given : User should be able to see mail addresses in the email box
    Then  : User should be able to select skills
    And   : User should be able to feel "<fullName>" "<phoneNumber>" "<website>" and "<companySize>" information
    Then  : User should be able to and submit application successfully
    When  : User try to create booking
    Then  : User should be able to see the booking page

    Examples:
      | fullName | phoneNumber | website        | companySize |
      | John Doe | 5076095085  | www.google.com | 11-50       |



