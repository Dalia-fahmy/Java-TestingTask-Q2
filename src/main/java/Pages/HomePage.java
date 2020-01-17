package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(className ="ico-register")
    public WebElement registrationBtn;

    @FindBy(linkText ="Log in")
    public WebElement loginLink;

    public void OpenRegistrationPage()
    {
        registrationBtn.click();
    }
    public void OpenLoginPage()
    {
        loginLink.click();

    }
}
