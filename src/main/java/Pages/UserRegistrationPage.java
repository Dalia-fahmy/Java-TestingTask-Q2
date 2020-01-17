package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegistrationPage extends PageBase
{
    public UserRegistrationPage (WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "gender-female")
    WebElement genderBtn;

    @FindBy(id = "FirstName")
    WebElement FnTextBox;

    @FindBy(id = "LastName")
    WebElement LnTextBox;

    @FindBy(id = "Email")
    WebElement ETextBox;

    @FindBy(id = "Password")
    WebElement PwTestBox;

    @FindBy(id = "ConfirmPassword")
    WebElement CPwTestBox;

    @FindBy(id = "register-button")
    WebElement RegisterBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(xpath ="//a[@class='ico-logout']")
     WebElement logoutLink;

    public void userRegistration (String fristName , String lastName , String email , String password)
    {
        genderBtn.click();
        FnTextBox.clear();
        LnTextBox.clear();
        ETextBox.clear();
        PwTestBox.clear();
        CPwTestBox.clear();
        FnTextBox.sendKeys(fristName);
        LnTextBox.sendKeys(lastName);
        ETextBox.sendKeys(email);
        PwTestBox.sendKeys(password);
        CPwTestBox.sendKeys(password);
        RegisterBtn.click();


    }
    public void userLogout()
    {
        logoutLink.click();
    }
}
