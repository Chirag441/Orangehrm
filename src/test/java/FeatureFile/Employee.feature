Feature:  Create a new user
  @chirag
  Scenario Outline: Creating a user and Deleting the user
# user details are in exel file
    Given User Is on login Page
    When  login As Admin
    Then  Switch to "<tab>" tab
    And add the Employe
    And Verify the employee
    And Delete the Employee
    Examples:
      |tab|
    |PIM|


  @chirag @user
  Scenario Outline: Creating a user and login with that user
# user details are in exel file
    Given User Is on login Page
    When  login As Admin
    Then  Switch to "<tab>" tab
    And add the Employe
    And Verify the employee
    And Logout the user
    And Login as user


    Examples:
    |tab|
    |PIM|


  @chirag
  Scenario Outline: Employee Leave
      # Adding employee leave and use the leave from employee and  verifying ir from admin end
    Given User Is on login Page
    When  login As Admin
    Then  Switch to "<tab>" tab
    And add the Employe
    And Verify the employee
    Then  Switch to "<tab1>" tab
    And Add Leaves to Employee
    And Logout the user
    And Login as user
    Then  Switch to "<tab1>" tab
    And Verify the employee Leave Details
    Examples:
      |tab||tab1|
      |PIM||Leave|


