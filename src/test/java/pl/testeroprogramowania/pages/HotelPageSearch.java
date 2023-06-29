package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPageSearch {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(name = "checkin")
    private WebElement checkinInput;

    @FindBy(name = "checkout")
    private WebElement checkoutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//th[@class='next']")
    private WebElement nextMonth;

    @FindBy(xpath = "//td[@class='day ' and text()='10']")
    private WebElement day;

    @FindBy(xpath = "//a[@class='btn btn-warning btn-block']")
    private WebElement supplierSignUp;

    private WebDriver driver;

    public HotelPageSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setCityName(String cityName) {
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setDates(String checkin, String checkout) {
        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
    }

    public void setTravellers(int adultToAdd, int childToAdd) {
        travellersInput.click();
        addTraveler(adultPlusBtn, adultToAdd);
        addTraveler(childPlusBtn, childToAdd);
    }


    private void addTraveler(WebElement travellersButton, int numberOfTravellers) {
        for (int i = 0; i < numberOfTravellers; i++) {
            travellersButton.click();
        }
    }

    public void performerSearch() {
        searchButton.click();
    }

    public void setNewCheckinData() {
        checkinInput.click();
        nextMonth.click();
        day.click();
        checkinInput.click();
    }

    public void setNewCheckoutData() {
        checkoutInput.click();
        WebElement nextMonth = driver.findElements(By.xpath("//th[@class='next']")).get(3);
        Actions actions = new Actions(driver);
        actions.doubleClick(nextMonth).perform();
        day.click();
    }

    public void openSupplierSignUp() {
        supplierSignUp.click();
    }
}
