package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UserRegistrationTest extends TestBase
{
    HomePage homeObject;
    UserRegistrationPage registerObject;

  @Test(priority = 1 , alwaysRun = true)
    public void SuccessfulRegistration ()
    {
    homeObject = new HomePage(driver);
    homeObject.OpenRegistrationPage();
    registerObject = new UserRegistrationPage(driver);
    registerObject.userRegistration("test","task","testtask100@yahoo.com","testdata12345");
    Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = {"SuccessfulRegistration"})
    public void SuccessfulLogout()
    {

        registerObject.userLogout();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(homeObject.loginLink.getText().contains("Log in"));


    }

}
