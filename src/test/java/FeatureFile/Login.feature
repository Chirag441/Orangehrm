Feature: UserLogin

@chirag
  Scenario: Verify User is Login

    Given User Is on login Page
    When  login As Admin
    Then Page Verification
    And Logout the user

