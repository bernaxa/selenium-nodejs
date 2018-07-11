var webdriver = require('selenium-webdriver');
var logging = require('selenium-webdriver').logging;

var prefs = new logging.Preferences();
    prefs.setLevel(logging.Type.DRIVER, logging.Level.ALL);

var chromeCapabilities = webdriver.Capabilities.chrome();
    chromeCapabilities.set('chromeOptions', {
      'args': ['--headless', '--disable-gpu']
    });

var driver = new webdriver.Builder().
    setProxy(proxy.manual({ http : 'egress-http-proxy:8080',
      https : 'egress-http-proxy:8080',
      })).
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(chromeCapabilities).
    setLoggingPrefs(prefs).
    build();

driver.get('http://www.google.com/ncr');
driver.quit();

