package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.models.Costomer;

public class SupplierRegistrationPage {

    @FindBy(id = "tours")
    private WebElement toursButton;

    @FindBy(name = "itemname")
    private WebElement tourName;

    @FindBy(name = "fname")
    private WebElement firstName;

    @FindBy(name = "lname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement emailImput;

    @FindBy(name = "mobile")
    private WebElement phone;

    @FindBy(name = "country")
    private WebElement countrySelect;

    @FindBy(name = "state")
    private WebElement stateInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "address1")
    private WebElement address1Imput;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement alertSuccess;

    private WebDriver driver;

    public SupplierRegistrationPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void openRegister () {
        toursButton.click();
    }

    public void registerData(Costomer costomer, String email) {
        tourName.sendKeys(costomer.getTourName());
        firstName.sendKeys(costomer.getFirstName());
        lastName.sendKeys(costomer.getLastName());
        emailImput.sendKeys(email);
        phone.sendKeys(costomer.getPhone());
        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByVisibleText(costomer.getCountry());
        stateInput.sendKeys(costomer.getState());
        cityInput.sendKeys(costomer.getCity());
        address1Imput.sendKeys(costomer.getAddress());
        registerButton.click();
    }

    public String getAlertSuccess() {
        return alertSuccess.getText();
    }
}
