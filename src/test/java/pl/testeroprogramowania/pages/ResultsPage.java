package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage {

    @FindBy(xpath = "//h4[@class='RTL go-text-right mt0 mb4 list_title']//b")
    private List<WebElement> hotelList;

    @FindBy(linkText = "Grand Plaza Apartments")
    private WebElement goToHotel;

    private WebDriver driver;

    public ResultsPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public List<String> getHotelList() {
        return hotelList.stream()
                .map(el->el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public void openHotelPage () {
        goToHotel.click();
    }
}
