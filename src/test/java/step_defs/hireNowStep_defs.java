package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.hireNow;
import pages.mainPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.EnvUtil;

public class hireNowStep_defs {

    mainPage mainPage = new mainPage();
    hireNow  hireNow = new hireNow();

    @Given(": User on the main URL")
    public void userOnTheMainURL() {

        String url = EnvUtil.getFromEnv("url");
        Driver.get().get(url);

    }

    @Given(": User should be able to write work mail to enter your work email space")
    public void userShouldBeAbleToWriteWorkMailToEnterYourWorkEmailSpace() {

        String actualLanguage = mainPage.language.getText();

        if(actualLanguage.equals("TR")){
            BrowserUtils.clickWithJS(mainPage.language);
            mainPage.choiceEnglish.click();
            System.out.println("actualLanguage = " + actualLanguage);
        }

        BrowserUtils.waitFor(1);
        mainPage.enterYourWorkEmail.click();
        mainPage.enterYourWorkEmail.sendKeys(EnvUtil.getFromEnv("mail"));

    }

    @Then(": User should be able to click Hire Now button")
        public void userShouldBeAbleToClickHireNowButton() {

        mainPage.hireNowButton.click();

    }

    @And(": User should be able to see the next page to continue to fill information")
    public void userShouldBeAbleToSeeTheNextPageToContinueToFillInformation() {

        BrowserUtils.waitFor(1);
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("gmail.com"));

    }

    @Given(": User should be able to see mail addresses in the email box")
    public void userShouldBeAbleToSeeMailAddressesInTheEmailBox() {

        String actualMail = hireNow.emailInputBox.getAttribute("value");
        Assert.assertTrue(actualMail.equals(EnvUtil.getFromEnv("mail")));

    }

    @Then(": User should be able to select skills")
    public void userShouldBeAbleToSelectSkills() {

        hireNow.selectSkills("Android").click();
        hireNow.selectSkills("Angular").click();
        hireNow.clickButton("Continue").click();
        BrowserUtils.waitFor(5);

    }

    @Then(": User should be able to and submit application successfully")
    public void userShouldBeAbleToAndSubmitApplicationSuccessfully() {

        BrowserUtils.waitForVisibility(hireNow.thankYouMessage, 5);
        String actualMessage = hireNow.thankYouMessage.getText();
        String expectedMessage = "Thank You!";
        Assert.assertTrue(actualMessage.equals(expectedMessage));



    }

    @And(": User should be able to feel {string} {string} {string} and {string} information")
    public void userShouldBeAbleToFeelAndInformation(String fullName, String phone, String website, String size) {
        hireNow.nameSurname.sendKeys(fullName);
        hireNow.phoneNumber.sendKeys(phone);
        hireNow.website.sendKeys(website);
        hireNow.companySizeClick.click();
        hireNow.companySize(size);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitFor(1);
        hireNow.clickButton("Next").click();


    }

    @When(": User try to create booking")
    public void userTryToCreateBooking() {

    }

    @Then(": User should be able to see the booking page")
    public void userShouldBeAbleToSeeTheBookingPage() {
    }
}
