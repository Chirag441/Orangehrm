Feature:  Create a new user
  @chirag
  Scenario: Creating a user and Deleting the user
# user details are in exel file
    Given User Is on login Page
    When  login to Home page
    Then  Switch to "PIM" tab
    And add the Employe
    And Verify the employee
    And Delete the Employee


  @chirag
  Scenario: Creating a user and login with that user
# user details are in exel file
    Given User Is on login Page
    When  login to Home page
    Then  Switch to "PIM" tab
    And add the Employe
    And Verify the employee
    And Logout the user
    And Login as user