Feature: Login Page
  Login to the website

  @login1
  Scenario: LoginToRSA
    Given the user launches the application "RSA"
    When the user enters the "#(username)" into the "RSA_Login_Username" textbox at the "RSA_Login" page
    And the user enters the "#(password)" into the "RSA_Login_Password" textbox at the "RSA_Login" page
    Then the user clicks on the "RSA_Login_Login" at the "RSA_Login" page
    
  @login2
  Scenario: LoginToSwagLabs
    Given the user launches the application "SwagLabs"
    When the user enters the "standard_user" into the "SwagLabs_Login_Username" textbox at the "SwagLabs_Login" page
    And the user enters the "#(password)" into the "SwagLabs_Login_Password" textbox at the "SwagLabs_Login" page
    Then the user clicks on the "SwagLabs_Login_Login" at the "SwagLabs_Login" page
    