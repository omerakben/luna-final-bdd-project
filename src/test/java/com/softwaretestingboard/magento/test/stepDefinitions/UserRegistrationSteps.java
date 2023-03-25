package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.main.pages.RegistrationPage;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

public class UserRegistrationSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage;
    private RegistrationPage registrationPage;

    @Given("the user is on the Magento homepage")
    public void the_user_is_on_the_magento_homepage() {
        homePage = new HomePage(driver);
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
        if (linkText.equals("Create an Account")) {
            homePage.navigateToRegistrationPage();
            registrationPage = new RegistrationPage(driver);
        }
    }

    @When("the user fills in the required details and submits the form")
    public void the_user_fills_in_the_required_details_and_submits_the_form() {
        String fName = "Katia";
        String lName = "Barlas";
        String email = "diana123@google.com";
        String password = "oscarAkben90!";
        String confirmPassword = "oscarAkben90!";

        registrationPage.registerUser(fName, lName, email, password, confirmPassword);
    }

    @Then("the user should be successfully registered and redirected to the My Account page")
    public void the_user_should_be_successfully_registered_and_redirected_to_the_my_account_page() {
        assertTrue(registrationPage.isRegistrationSuccessful());
    }
}
