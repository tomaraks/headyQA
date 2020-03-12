package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WindowManager;

import java.util.List;

public class LaptopsPage {
    private WebDriver driver;
    private By selectSort = By.cssSelector("#s-result-sort-select");

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method Overloading
    public void checkOption(String option) {
        checkOption(option, 0);
    }

    public void checkOption(String option, int flag) {
        String startId = "";
        if (flag == 1)
            startId = "leftNav";
        else startId = "filters";
        List<WebElement> allElements = driver.findElement(By.id(startId)).findElements(By.tagName("ul"));
        outer:
        for (WebElement webElement : allElements) {
            if (webElement.getText().contains(option)) {
                List<WebElement> allElements1 = webElement.findElements(By.tagName("li"));
                for (WebElement webElement1 : allElements1) {
                    if (webElement1.getText().equalsIgnoreCase(option)) {
                        webElement1.click();
                        break outer;
                    }
                }
            }
        }
    }

    public void sortOption(String option) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)");
        Select select = new Select(driver.findElement(selectSort));
        select.selectByVisibleText(option);
    }

    public WindowManager selectFirstOptionsFromTop() {
        List<WebElement> lst = driver.findElements(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row h2 > a"));
        lst.get(0).click();
        return new WindowManager(driver);
    }
}

