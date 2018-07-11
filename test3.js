import webdriver from 'selenium-webdriver'
import test from 'selenium-webdriver/testing'

test.describe('Test', () => {
  test.it('with headless chrome.', () => {
    const chromeCapabilities = webdriver.Capabilities.chrome();
    chromeCapabilities.set('chromeOptions', {
      'args': ['--headless', '--disable-gpu']
    });
    driver = new webdriver.Builder()
      .usingServer('http://selenium-hub:4444/wd/hub')
      .withCapabilities(chromeCapabilities)
      .build();

    driver.get('http://www.google.com/');
    driver.quit();
  })
})
