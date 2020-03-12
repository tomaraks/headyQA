package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void switchToNewTab() {
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}