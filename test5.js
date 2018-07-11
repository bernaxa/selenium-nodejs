var webdriver = require('selenium-webdriver');

var driver = new webdriver.Builder().
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(webdriver.Capabilities.chrome()).
    build();

driver.get('http://www.google.com/ncr');
driver.quit();

