Feature: Login Feature

  Scenario: Login with Valid credentials
    Given Login to the website
    And enter valid mobile number
    And click on Generate OTP
    When login successful it should show your name
		