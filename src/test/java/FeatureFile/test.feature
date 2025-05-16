Feature:  user create , adding leave

@create
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


@leave
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
And verify the Leave count added by admin
Then Apply for the leave
Then  Switch to "<tab1>" tab
 # Then Apply for the leave


Examples:
|tab||tab1|
|PIM||Leave|

#@leave
Scenario Outline:  test
  Given User Is on login Page
  And Login as user
  Then  Switch to "<tab1>" tab
  And verify the Leave count added by admin

  Then Apply for the leave
  And Logout the user
  When login As Admin

  Examples:
    |tab1|
  |Leave|
