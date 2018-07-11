var webdriver = require('selenium-webdriver');
var logging = require('selenium-webdriver').logging;

var prefs = new logging.Preferences();
    prefs.setLevel(logging.Type.DRIVER, logging.Level.ALL);

var chromeCapabilities = webdriver.Capabilities.chrome();
    chromeCapabilities.set('chromeOptions', {
      'args': ['--headless', '--disable-gpu']
    });

var proxy = require('selenium-webdriver/proxy');

var driver = new webdriver.Builder().
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(chromeCapabilities).
    setProxy(proxy.manual({http: 'egress-http-proxy:8080'})).
    setLoggingPrefs(prefs).
    build();

driver.get('http://www.google.com/ncr');
driver.quit();

