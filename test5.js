const webdriver = require('selenium-webdriver');

describe("try", function() {
    it("try", function() {
        logging.installConsoleHandler();
        logging.getLogger('promise.ControlFlow').setLevel(logging.Level.ALL);

        let driver = new Builder()
            .forBrowser('chrome')
            .usingServer('http://selenium-hub:4444/wd/hub')
            .build();

        driver.get('http://www.google.com/ncr');
        driver.findElement(By.name('q')).sendKeys('webdriver');
        driver.findElement(By.name('btnK')).click();
        driver.wait(until.titleIs('webdriver - Google Search'), 1000);
        driver.quit();
    })
})
