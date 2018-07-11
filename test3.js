
const assert = require('assert'),
const test = require('selenium-webdriver/testing'),
const webdriver = require('selenium-webdriver');
 
test.describe('Google Search', function() {
  test.it('should work', function() {
    const chromeCapabilities = webdriver.Capabilities.chrome();
    chromeCapabilities.set('chromeOptions', {
      'args': ['--headless', '--disable-gpu']
    });
    const driver = new webdriver.Builder().
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(chromeCapabilities).
    build();

    driver.get('http://www.google.com');
    const searchBox = driver.findElement(webdriver.By.name('q'));
    searchBox.sendKeys('simple programmer');
    searchBox.getAttribute('value').then(function(value) {
      assert.equal(value, 'simple programmer');
    });
    driver.quit();
  });
});
