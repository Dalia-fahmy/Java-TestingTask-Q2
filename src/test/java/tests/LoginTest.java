package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @Test(priority = 1 , alwaysRun = true)
    public void RegisteredUserCanLogin()
    {
        homeObject = new HomePage(driver);
        homeObject.OpenLoginPage();
        loginObject = new LoginPage(driver);
        //   Assert.assertTrue(loginObject.loginMessage.getText().contains("Welcome, Please Sign In!"));
        loginObject.userLogin("qatest30@yahoo.com", "testdata12345");
    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogin"})
    public void SuccessfulLogout()
    {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userLogout();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(homeObject.loginLink.getText().contains("Log in"));
    }
}
