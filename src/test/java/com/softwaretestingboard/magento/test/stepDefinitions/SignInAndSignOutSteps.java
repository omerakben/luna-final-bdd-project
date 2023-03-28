package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.BasePage;
import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.main.pages.SignInPage;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SignInAndSignOutSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    BasePage basePage;
    HomePage homePage;
    SignInPage signInPage;
    ElementUtils elementUtils;

    @Given("user is on the Magento homepage")
    public void user_is_on_the_magento_homepage() {
        basePage = new BasePage(driver);
    }
    @When("the user clicks on the Login in button")
    public void the_user_clicks_on_the_login_in_button() {
        elementUtils = new ElementUtils(driver);
        assertTrue(basePage.getSignInBtn().isDisplayed() && basePage.getSignInBtn().isEnabled());
//        elementUtils.clickOnElement(basePage.getSignInBtn(), 3);
        basePage.getSignInBtn().click();
    }
    @Then("user is on the Login page")
    public void user_is_on_the_login_page() {
        signInPage = new SignInPage(driver);
        assertTrue(signInPage.getCustomerLoginText().isDisplayed());
    }
    @And("user enters {string} and {string} and clicks on sign in button")
    public void user_enters_and_and_clicks_on_sign_in_button(String email, String password) {
        signInPage.signIn(email,password);
    }

    @When("user is on the Home page should be able to see his or her full name in the welcome message in the top right corner")
    public void userIsOnTheHomePageShouldBeAbleToSeeHisOrHerFullNameInTheWelcomeMessageInTheTopRightCorner() {
        homePage = new HomePage(driver);
        assertTrue(basePage.getUsersNameText().isDisplayed());
    }

    @And("user should be able to clicks on down arrows next to his or her name and click “My Account” option under his or her name.")
    public void userShouldBeAbleToClicksOnDownArrowsNextToHisOrHerNameAndClickMyAccountOptionUnderHisOrHerName() throws InterruptedException {
        assertTrue(basePage.getUserDropdownMenu().isEnabled());
        basePage.getUserDropdownMenu().click();
        assertTrue(basePage.getMyAccountLink().isDisplayed() && basePage.getMyAccountLink().isEnabled());
        elementUtils.clickOnElement(basePage.getMyAccountLink(), 3);
        Thread.sleep(3000);
    }

    @And("user should be able to clicks on down arrows next to his or her name and sign out")
    public void userShouldBeAbleToClicksOnDownArrowsNextToHisOrHerNameAndSignOut() {
        assertTrue(basePage.getUserDropdownMenu().isEnabled());
        basePage.getUserDropdownMenu().click();
        assertTrue(basePage.getSignOutBtn().isDisplayed() && basePage.getSignOutBtn().isEnabled());
        elementUtils.clickOnElement(basePage.getSignOutBtn(), 3);
    }
}
