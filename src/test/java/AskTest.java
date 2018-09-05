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

    private WebDriver driver;
	
    @Test
    public void shouldAskGoogleForWebDriver() {
         
        ChromeOptions opts = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), opts);
	
	try {
		//driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), opts);
		driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), opts);
		//driver = new RemoteWebDriver(new URL("http://mobile-sp:f0467e7b-4024-4198-94f6-328384cf56a2@ondemand.saucelabs.com:80/wd/hub"), opts);
	}
	catch(MalformedURLException e) {
		System.out.println("The url is not well formed: ");
	}	    

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
