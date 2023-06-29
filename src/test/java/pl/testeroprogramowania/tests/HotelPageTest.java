package pl.testeroprogramowania.tests;

import org.junit.Assert;
import org.junit.Test;
import pl.testeroprogramowania.pages.BookPage;
import pl.testeroprogramowania.pages.HotelPage;
import pl.testeroprogramowania.pages.HotelPageSearch;
import pl.testeroprogramowania.pages.ResultsPage;

import java.util.List;

public class HotelPageTest extends BasicTest {

    @Test
    public void hotelPageTest() {
        HotelPageSearch hotelPageSearch = new HotelPageSearch(driver);
        hotelPageSearch.setCityName("Dubai");
        hotelPageSearch.setDates("20/06/2023", "25/05/2023");
        hotelPageSearch.setTravellers(2, 4);
        hotelPageSearch.performerSearch();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelName = resultsPage.getHotelList();

        Assert.assertEquals(hotelName.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelName.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelName.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelName.get(3), "Hyatt Regency Perth");
    }

    @Test
    public void hotelPageTest2() {
        HotelPageSearch hotelPageSearch = new HotelPageSearch(driver);
        hotelPageSearch.setCityName("London");
        hotelPageSearch.setNewCheckinData();
        hotelPageSearch.setNewCheckoutData();
        hotelPageSearch.setTravellers(0, 1);
        hotelPageSearch.performerSearch();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelName = resultsPage.getHotelList();

        Assert.assertEquals(hotelName.get(0), "Grand Plaza Apartments");

        resultsPage.openHotelPage();

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.hotelCheckbox();
        hotelPage.bookNaw();

        BookPage bookPage = new BookPage(driver);

        Assert.assertEquals(bookPage.getErrorText(), "Ops!");
        Assert.assertEquals(bookPage.getErrorSecond(), "Something wrong baby please try again.");
    }
}
