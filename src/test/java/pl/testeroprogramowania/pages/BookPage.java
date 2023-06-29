package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {

    @FindBy(xpath = "//h1[@class='text-center strong']")
    private WebElement error;

    @FindBy(xpath = "//h3[@class='text-center']")
    private WebElement errorSecond;

    private WebDriver driver;

    public BookPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String getErrorText() {
        return error.getText();
    }

    public String getErrorSecond() {
        return errorSecond.getText();
    }

}
