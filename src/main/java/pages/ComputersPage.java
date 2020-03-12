package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    private WebDriver driver;

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    public LaptopsPage clickLaptops() {
        clickLink("Laptops");
        return new LaptopsPage(driver);
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
