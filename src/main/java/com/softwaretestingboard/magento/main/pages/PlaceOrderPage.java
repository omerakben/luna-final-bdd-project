package com.softwaretestingboard.magento.main.pages;



import com.softwaretestingboard.magento.main.utils.ConfigReader;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static com.softwaretestingboard.magento.main.utils.CommonUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PlaceOrderPage {
    WebDriver driver;
    ConfigReader configReader;
    ElementUtils elementUtils;


@FindBy(xpath = "//span[contains(.,'Women')]")
public WebElement womenBtn;
@FindBy(xpath = "(//div[@class='product-item-info'])[1]")
public WebElement product;
@FindBy (xpath = "//div[@id='option-label-color-93-item-50']")
public WebElement colorOfProduct;
@FindBy (xpath = "//input[@id='qty']")
public WebElement quanityOption;
@FindBy (xpath = "//div[@id='option-label-size-143-item-166']")
public WebElement sizeOfProduct;
@FindBy (xpath = "//button[@id='product-addtocart-button']")
public  WebElement addToCartBtn;
@FindBy (xpath = "//a[@class='action showcart']")
public WebElement cartBtn;
@FindBy (xpath = "//span[@role='tab']")
public WebElement seeDetailsBtn;
@FindBy (xpath = "//span[@data-bind='text: option.value'][normalize-space()='XS']")
public WebElement xsSizeDetail;
@FindBy (xpath = "//span[@data-bind='text: option.value'][normalize-space()='Blue']")
public WebElement blueSizeDetail;
@FindBy (xpath = "//button[@id='top-cart-btn-checkout']")
public WebElement proceedToCheckOutBtn;
@FindBy (xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
public WebElement messageSuccess;
@FindBy (xpath = "//a[normalize-space()='Radiant Tee']")
public WebElement nameOfProductInCart;
@FindBy (xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
public WebElement emailInput;
@FindBy (name = "firstname")
public WebElement firstNameInput;
@FindBy (name = "lastname")
public WebElement lastNameInput;
@FindBy(name = "street[0]")
public WebElement streetAddressInput;
@FindBy (name ="city")
public WebElement cityNameInput;
@FindBy (name = "region_id")
public WebElement stateSelection;
@FindBy(name = "postcode")
public WebElement zipInput;
@FindBy (name = "country_id")
public WebElement countrySelection;
@FindBy(name = "telephone")
public WebElement phoneNumberInput;
@FindBy (xpath = "(//td[@class='col col-price'])/span")
public List<WebElement> radioBtnByPrice;
@FindBy(xpath = "//span[normalize-space()='Next']")
public  WebElement nextBtn;
@FindBy(xpath  ="//div[@class='ship-to']//div[@class='shipping-information-content']")
public WebElement shippingInfo;
@FindBy (xpath = "//div[@class='primary']/button[@type='submit']/span[.='Place Order']")
public WebElement placeOrderBtn;
@FindBy (xpath = "//span[.='Thank you for your purchase!']")
public  WebElement thankYouMessage;
@FindBy (xpath = "//div[@class='checkout-success']/p[contains(.,'Your order # is:')]")
public WebElement orderNumberMessage;
@FindBy (xpath = "//span[@data-bind='text: getEmailAddress()']")
public WebElement emailText;


    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public void navigateToWomenSSections() {
        womenBtn.click();
    }

    public void select_a_product_and_add_it_to_the_cart() {
        product.click();

    }

    public void selectProductSSizeColorAndQtyAndThenClickAddToCart(String qty) {
        sizeOfProduct.click();
        colorOfProduct.click();
        quanityOption.clear();
        quanityOption.sendKeys(qty);
        addToCartBtn.click();

    }

    public void click_on_shopping_cart_button_and_verify_that_the_correct_item_was_added_to_cart() throws InterruptedException {
        Thread.sleep(2_000);
        //elementUtils.clickOnElement(cartBtn,2);
        cartBtn.click();
        seeDetailsBtn.click();
        assertEquals(xsSizeDetail.getText(),"XS".trim());
        assertEquals(blueSizeDetail.getText(), "Blue".trim());
        assertTrue(messageSuccess.getText().trim().contains(nameOfProductInCart.getText().trim()));


    }

    public void clickOnTheProceedToCheckoutButtonToNavigateToTheCheckoutPage() {
        proceedToCheckOutBtn.click() ;

    }

    public void verify_that_landed_on_check_out_page() {
       assertEquals("Landed on wrong page", driver.getTitle(), "Checkout".trim());

    }


    public void fillOutShippingInfoThatSProvidedOnThisPageAndThenClickNextBtn () {
        configReader = new ConfigReader();
        String randomEmail = randomEmail();
        configReader.setProperty("email", randomEmail);

        emailInput.sendKeys(randomEmail);

       firstNameInput.sendKeys(randomFirstName());
       lastNameInput.sendKeys(randomLastName());
       streetAddressInput.sendKeys(randomStreetName());
       cityNameInput.sendKeys(randomCity());
        Select select = new Select(stateSelection);
        select.selectByVisibleText(randomState());
        zipInput.sendKeys(randomZip());
        Select select1 = new Select(countrySelection);
        select1.selectByVisibleText("United States");
        phoneNumberInput.sendKeys(randomPhoneNumber());

        int randomIndex = (int) (Math.random() * radioBtnByPrice.size());
        radioBtnByPrice.get(randomIndex).click();

        nextBtn.click();
    }


    public void verifyShipToSectionAndThenClickOnPlaceOrderBtn() throws InterruptedException {
        assertTrue(shippingInfo.isDisplayed());
        Thread.sleep(1_000);
        placeOrderBtn.click();
    }


    public void verifyThankYouForYourPurchaseMessage() {
        assertTrue(thankYouMessage.isDisplayed());
    }

    public void verify_that_order_number_was_provided() {
        assertTrue(orderNumberMessage.isDisplayed());

    }

    public void verify_email_address_shows_as_registered( ) {
        Assert.assertEquals("emails do not match", emailText.getText().trim(),configReader.getProperty("email"));


    }



}
