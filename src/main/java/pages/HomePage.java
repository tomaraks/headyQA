package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickPartialLink("Hello. Sign in");
        return new LoginPage(driver);
    }

    private void clickPartialLink(String partialLinkText){
        driver.findElement(By.partialLinkText(partialLinkText)).click();
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public ComputersPage clickComputers(){
        clickLink("Computers");
        return new ComputersPage(driver);
    }

}
