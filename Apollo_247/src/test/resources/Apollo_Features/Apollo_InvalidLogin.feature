Feature: InvalidLogin Feature

  Scenario: Login with Invalid credentials
    Given Login to the website
    And enter Invalid Mobile Number
    And user cannot click on Generate OTP
    Then user is still on home page
