Feature: Login Page
  Login to the website

  @login
  Scenario: LoginToRSA
    Given the user launches the application "RSA"
    When the user enters the "#(username)" into the "RSA_Login_Username" textbox at the "RSA_Login" page
    And the user enters the "#(password)" into the "RSA_Login_Password" textbox at the "RSA_Login" page
    Then the user clicks on the "Login" at the "RSA_Login" page
    
  @login2
  Scenario: LoginToRSA
    Given the user launches the application "RSA"
    When the user enters the "testFramework_SHS@gmail.com" into the "RSA_Login_Username" textbox at the "RSA_Login" page
    And the user enters the "#(password)" into the "RSA_Login_Password" textbox at the "RSA_Login" page
    Then the user clicks on the "Login" at the "RSA_Login" page
    