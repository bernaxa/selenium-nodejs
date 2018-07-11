require('chromedriver');
const webdriver = require('selenium-webdriver');
const { By, until } = webdriver;

const chai = require('chai');
const chaiAsPromised = require('chai-as-promised');

chai.use(chaiAsPromised);
const driver = new webdriver.Builder().forBrowser('chrome').build();
const expect = chai.expect;

var serverUri = 'http://www.google.es';

describe('basic test', function () {
    var driver;
    before(function(){
        driver = new webdriver.Builder().
        usingServer('http://selenium-hub:4444/wd/hub').
        withCapabilities(webdriver.Capabilities.chrome()).
        build();
        console.log("Selenium Webdriver Chrome Started");
    });

    after(function(){
        driver.quit();
    });

    it('should be on correct page', function (done) {
        this.timeout(10000);
        driver.get(serverUri);
        driver.getTitle().then(function(title) {
            expect(title).to.equal('Google');
            done();
            console.log("Selenium Webdriver Chrome Shutdown");
        })
    });
});
