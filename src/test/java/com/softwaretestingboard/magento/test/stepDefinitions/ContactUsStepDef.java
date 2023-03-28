package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.ContactUsPage;
import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ContactUsStepDef {
    private final WebDriver driver = DriverFactory.getDriver();
    private ContactUsPage contactUsPage;
    private HomePage homePage;
    @Given("User is on the Luma Home Page")
    public void user_is_on_the_luma_home_page() {
        homePage =new HomePage(driver);
       boolean isOnHomePage = homePage.isHomePageDisplayed();
        if (isOnHomePage) {
            System.out.println("User is on the Luma Home Page.");
        } else {
            System.out.println("User is not on the Luma Home Page.");

        }
    }
    @When("User click on the Contact Us link")
    public void user_click_on_the_contact_us_link() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        homePage.clickContactUsLink();
    }
    @Then("User should be redirected to the Contact Us page")
    public void userShouldBeRedirectedToTheContactUsPage() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.isContactUsPageDisplayed();
        assertTrue(contactUsPage.isContactUsPageDisplayed());
    }
    @Given("User is on the contact us form")
    public void user_is_on_the_contact_us_form() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.isContactUsPageDisplayed();
    }
    @When("User fill out the contact us form")
    public void user_fill_out_the_contact_us_form() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        String name = "Alex";
        String emailAddress = "kenaa@example.com";
        String phoneNumber = "1234567890";
        String Comment ="My order arrived";
       contactUsPage.fillContactUsForm(name, emailAddress, phoneNumber, Comment);
    }
    @When("User  submit the form")
    public void user_submit_the_form() {
        contactUsPage.submitContactUsForm();
    }
    @Then("User should see a successful message")
    public void user_should_see_a_successful_message() {
        boolean isMessageDisplayed = contactUsPage.isConfirmSubmitFormMessageDisplayed();
        assertTrue("Failed: Confirm Submit Form message is not displayed", isMessageDisplayed);
    }
    @Given("User is on the contact us page")
    public void user_is_on_the_contact_us_page() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.isContactUsPageDisplayed();
    }
    @When("User fill out the form with invalid email address {string},{string} ,{string}")
    public void userFillOutTheFormWithInvalidEmailAddress(String name, String invalidEmail, String comment) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        contactUsPage.userFillsOutFormWithInvalidEmail(name, invalidEmail, comment);
    }
    @When("User submit the Contact Us form")
    public void user_submit_the_contact_us_form() {
        contactUsPage.submitContactUsForm();
    }
    @Then("User should see an error message {string}")
    public void user_should_see_error_message(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.id("email-error")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
