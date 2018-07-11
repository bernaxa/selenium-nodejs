var webdriver = require('selenium-webdriver');
var logging = require('selenium-webdriver').logging;

var prefs = new logging.Preferences();
    prefs.setLevel(logging.Type.BROWSER, logging.Level.ALL);

var driver = new webdriver.Builder().
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(webdriver.Capabilities.chrome()).
    setLoggingPrefs(prefs).
    build();

driver.get('http://www.google.com/ncr');
driver.quit();

