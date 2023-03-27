package com.softwaretestingboard.magento.main.pages;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactUsPage {
    WebDriver driver;
    public  ContactUsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory
    @FindBy(xpath = "//input[@name='name']")
     private  WebElement nameContactUsInput;
    @FindBy(id = "email")
    private WebElement emailContatUsInput;
    @FindBy(id="telephone")
    private WebElement telephoneContatUsInput;
    @FindBy(id="comment")
    private WebElement commentContatUsInput;
    @FindBy(xpath = "//button[@type='submit']//span[text()='Submit']")
    private WebElement submitContatUsButton;
    @FindBy(xpath = "//h1/span[text()='Contact Us']")
    private WebElement contactUsTitle;
    @FindBy(xpath = "//a[text()='Contact Us']")
    private WebElement contactUsLink;
    @FindBy(xpath = "//div[@role='alert']/div/div")
    private WebElement confirmSubmitFormMessage;
   @FindBy(id = "email-error")
   private WebElement expectedErrorMessage;

    public void fillContactUsForm(String name, String emailAddress,String phoneNumber, String comment) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        nameContactUsInput.sendKeys(name);
        emailContatUsInput.sendKeys(emailAddress);
        telephoneContatUsInput.sendKeys(phoneNumber);
        commentContatUsInput.sendKeys(comment);
    }
    public boolean isContactUsPageDisplayed() {
        // Check if the contactUsTitle WebElement object is not null and is displayed
        return contactUsTitle != null && contactUsTitle.isDisplayed();
    }
    public void submitContactUsForm() {
        submitContatUsButton.click();
    }
    public boolean isConfirmSubmitFormMessageDisplayed() {
        ElementUtils elementUtils = new ElementUtils(driver);
        elementUtils.waitForAlert(10);
        if(confirmSubmitFormMessage == null) {
            System.out.println("confirmSubmitFormMessage WebElement is null");
            return false;
        } else if(!confirmSubmitFormMessage.isDisplayed()) {
            System.out.println("confirmSubmitFormMessage WebElement is not displayed");
            return false;
        } else {
            System.out.println("confirmSubmitFormMessage WebElement is displayed");
            return true;
        }
    }
    public void userFillsOutFormWithInvalidEmail(String name, String invalidEmail, String comment) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        emailContatUsInput.clear();
        nameContactUsInput.sendKeys(name);
        emailContatUsInput.sendKeys(invalidEmail);
        commentContatUsInput.sendKeys(comment);
    }

    public void userSeeTheErrorMessage( String expectedErrorMessage){
        ElementUtils elementUtils = new ElementUtils(driver);
        elementUtils.waitForAlert(10);
        if(confirmSubmitFormMessage == null) {
            System.out.println("confirmSubmitFormMessage WebElement is null");
            return;
        }
        if(!confirmSubmitFormMessage.isDisplayed()) {
            System.out.println("confirmSubmitFormMessage WebElement is not displayed");
            return;
        }
        System.out.println("confirmSubmitFormMessage WebElement is displayed");
    }
}
