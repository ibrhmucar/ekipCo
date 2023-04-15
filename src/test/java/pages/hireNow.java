package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class hireNow extends BasePage{

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy (xpath = "//input[@placeholder='Enter other skills']")

    public WebElement enterOtherSkillsBox;

    @FindBy (id= "full-name")
    public WebElement nameSurname;



    public WebElement selectSkills(String skills){

   return Driver.get().findElement(By.xpath("//img[contains(@alt,'"+skills+"')]"));

    }
    public WebElement clickButton(String buttonName){

        return Driver.get().findElement(By.xpath("//button[contains(text(),'"+buttonName+"')]"));

    }



}
