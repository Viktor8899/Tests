package pl.testeroprogramowania.tests;

import org.junit.Assert;
import org.junit.Test;
import pl.testeroprogramowania.models.Costomer;
import pl.testeroprogramowania.pages.HotelPageSearch;
import pl.testeroprogramowania.pages.SupplierRegistrationPage;

import java.util.Set;

public class SupplierRegistrationTest extends BasicTest {

    @Test
    public void supplierRegistrationTest() {
        int random = (int) (Math.random() * 1000);
        Costomer costomer = new Costomer();
        HotelPageSearch hotelPageSearch = new HotelPageSearch(driver);
        String currentWindow = driver.getWindowHandle();
        hotelPageSearch.openSupplierSignUp();

        Set<String> windowName = driver.getWindowHandles();
        for (String window : windowName) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        SupplierRegistrationPage supplierRegistrationPage = new SupplierRegistrationPage(driver);
        supplierRegistrationPage.openRegister();
        supplierRegistrationPage.registerData(costomer, "piotr" + random + "@wp.pl");
        supplierRegistrationPage.getAlertSuccess();

        Assert.assertEquals(supplierRegistrationPage.getAlertSuccess(), "You have registered successfully. Once your account is approved you will receive further details");
    }
}
