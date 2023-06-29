package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelPage {

    @FindBy(xpath = "//div[@class='control__indicator']")
    private List<WebElement> checkbox;

    @FindBy(xpath = "//button[@class='book_button btn btn-md btn-success btn-block btn-block chk mob-fs10 loader']")
    private WebElement bookNawButton;

    private WebDriver driver;

    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void hotelCheckbox() {
        checkbox.get(2).click();
    }

    public void bookNaw() {
        bookNawButton.click();
    }
}
