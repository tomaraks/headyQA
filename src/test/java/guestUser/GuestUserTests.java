package guestUser;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ComputersPage;
import pages.LaptopsPage;
import utils.WindowManager;

public class GuestUserTests extends BaseTest {

    @Test
    public void guestUserBuyLaptopTest() {
        ComputersPage computersPage = homePage.clickComputers();
        LaptopsPage laptopsPage = computersPage.clickLaptops();
        laptopsPage.checkOption("Intel Core i7", 1);
        laptopsPage.checkOption("16 GB & more");
        laptopsPage.checkOption("13\" - 14\"");
        laptopsPage.sortOption("Price: Low to High");
        WindowManager windowManager = laptopsPage.selectFirstOptionsFromTop();
        windowManager.switchToNewTab();
    }
}
