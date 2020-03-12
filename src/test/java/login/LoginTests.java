package login;

import base.BaseTest;
import guestUser.GuestUserTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Properties;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(Properties.USERNAME);
        loginPage.clickContinueButton();
        loginPage.setPassword(Properties.PASSWORD);
        HomePage homePage = loginPage.clickLoginButton();
        assertEquals(homePage.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

        GuestUserTests guestUserTests = new GuestUserTests();
        guestUserTests.guestUserBuyLaptopTest();
    }
}
