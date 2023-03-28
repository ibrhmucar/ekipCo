package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage extends BasePage{


    @FindBy (xpath="(//input[@id='enter'])[1]")
    public WebElement enterYourWorkEmail;

    @FindBy (xpath = "//span[contains(text(),'Hire Now')]")
    public WebElement hireNowButton;



}
