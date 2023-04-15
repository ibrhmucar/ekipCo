package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage extends BasePage{


    @FindBy (xpath="(//input[@id='enter'])[1]")
    public WebElement enterYourWorkEmail;

    @FindBy (xpath = "//span[contains(text(),'Hire Now')]")
    public WebElement hireNowButton;

    @FindBy (xpath = "//div[@class='font-Gilroy text-[#373056] pl-2']")
    public WebElement language;

    @FindBy (xpath = "//img[@class='w-6 h-6 rounded-md']")
    public WebElement clickLanguage;

    @FindBy (xpath = "//span[@class='ml-3']")
    public WebElement choiceEnglish;


}
