import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AskTest {

    private WebDriver driver;
	
    @Test
    public void shouldAskGoogleForWebDriver() {
         
	Date now = new Date();
	DateFormat formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("1: " + formatter.format(now));    
	    
	System.getProperties().put("http.proxyHost", "egress-http-proxy");
	System.getProperties().put("http.proxyPort", "8080");
	System.getProperties().put("https.proxyHost", "egress-http-proxy");
	System.getProperties().put("https.proxyPort", "8080"); 	
	System.getProperties().put("http.nonProxyHosts","localhost|127.*|[::1]|selenium-hub|selenium-node-chrome|selenium-node-firefox|celenium-hub|celenium-node-chrome|celenium-node-firefox");		

	/*FirefoxOptions options = new FirefoxOptions();
	options.addPreference("network.proxy.type", 1);
    	options.addPreference("network.proxy.socks", "egress-http-proxy");
    	options.addPreference("network.proxy.socks_port", 8080);*/
	    
  	//Capabilities chromeCapabilities = DesiredCapabilities.chrome();
  	//Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
	    
        ChromeOptions options = new ChromeOptions();
	/*options.addArguments("--headless");
	options.addArguments("--no-sandbox");
	options.addArguments("--disable-gpu");*/

	// Add the WebDriver proxy capability.
	//Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("egress-http-proxy", 8080));
	//options.setCapability("proxy", proxy);
	options.addArguments("--proxy-server=http://egress-http-proxy:8080 --proxy-bypass-list=celenium-hub;celenium-node-chrome");
	    
	try {
		driver = new RemoteWebDriver(new URL("http://celenium-node-chrome:5555/wd/hub"), options);
		//driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), options);
		//driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
		//driver = new RemoteWebDriver(new URL("http://mobile-sp:f0467e7b-4024-4198-94f6-328384cf56a2@ondemand.saucelabs.com:80/wd/hub"), options);
		//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);
		//driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options.toCapabilities());
	}
	catch(MalformedURLException e) {
		System.out.println("The url is not well formed: ");
	}	    

	now = new Date();
	formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("2: " + formatter.format(now));    

	driver.get("http://www.axa-im.com");

	now = new Date();
	formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("3: " + formatter.format(now));    

        System.out.println("Title 1: " + driver.getTitle());

	now = new Date();
	formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("4: " + formatter.format(now));    
	    
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
	    
	now = new Date();
	formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("5: " + formatter.format(now));    

        System.out.println("Title 2: " + driver.getTitle());

	now = new Date();
	formatter = DateFormat.getTimeInstance();        // time only
	System.out.println("6: " + formatter.format(now));    

	driver.quit();
	/*WebDriver browser = new FirefoxDriver();

        browser.get("http://www.axa-im.com");

        WebElement inputField = browser.findElement(By.id("sb_form_q"));
        inputField.sendKeys("WebDriver");

        WebElement searchButton = browser.findElement(By.id("sb_form_go"));
        searchButton.click();

        browser.close();*/
    }
}
