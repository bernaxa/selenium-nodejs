import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AskTest {
    @Test
    public void shouldAskGoogleForWebDriver() {
        ChromeOptions opts = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), opts);
		driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), opts);
        driver.get("http://www.axa-im.com");
        System.out.println("Title 1: " + driver.getTitle());
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        System.out.println("Title 1: " + driver.getTitle());
        /*WebDriver browser = new FirefoxDriver();

        browser.get("http://www.axa-im.com");

        WebElement inputField = browser.findElement(By.id("sb_form_q"));
        inputField.sendKeys("WebDriver");

        WebElement searchButton = browser.findElement(By.id("sb_form_go"));
        searchButton.click();

        browser.close();*/
    }
}
