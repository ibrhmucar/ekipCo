package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

import java.text.BreakIterator;

public class hireNow extends BasePage{

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy (xpath = "//input[@placeholder='Enter other skills']")
    public WebElement enterOtherSkillsBox;

    @FindBy (id= "full-name")
    public WebElement nameSurname;

    @FindBy (xpath= "//input[@placeholder='Phone Number *'] ")
    public WebElement phoneNumber;

    @FindBy (id= "website")
    public WebElement website;

    @FindBy (xpath = "//div[@tabindex='0']")
    public WebElement companySizeClick;

    @FindBy (xpath = "//h3[contains(text(),'Thank You')]")
    public WebElement thankYouMessage;



    public void companySize(String value) {

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//li[@data-value='"+value+"']")), 5);
        Driver.get().findElement(By.xpath("//li[@data-value='"+value+"']")).click();

    }
    public WebElement selectSkills(String skills){

   return Driver.get().findElement(By.xpath("//img[contains(@alt,'"+skills+"')]"));

    }
    public WebElement clickButton(String buttonName){

        return Driver.get().findElement(By.xpath("//button[contains(text(),'"+buttonName+"')]"));

    }



}
