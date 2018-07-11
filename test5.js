var webdriver = require('selenium-webdriver');
var logging = require('selenium-webdriver').logging;

var prefs = new logging.Preferences();
    prefs.setLevel(logging.Type.DRIVER, logging.Level.ALL);

var chromeCapabilities = webdriver.Capabilities.chrome();
    chromeCapabilities.set('chromeOptions', {
      'args': ['--headless', '--disable-gpu']
    });

var proxy = require('selenium-webdriver/proxy');
var profile = new firefox.Profile();
profile.setPreference("network.proxy.type", 1); // Manual proxy config
profile.setPreference("network.proxy.http", "egress-http-proxy");
profile.setPreference("network.proxy.http_port", 8080);
profile.setPreference("network.proxy.ssl", "egress-http-proxy");
profile.setPreference("network.proxy.ssl_port", 8080);

var opts = new firefox.Options();
opts.setProfile(profile);

var driver = new webdriver.Builder().
    setChromeOptions(opts);
    usingServer('http://selenium-hub:4444/wd/hub').
    withCapabilities(chromeCapabilities).
    setLoggingPrefs(prefs).
    build();

driver.get('http://www.google.com/ncr');
driver.quit();

