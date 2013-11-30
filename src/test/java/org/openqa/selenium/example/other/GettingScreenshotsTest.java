package org.openqa.selenium.example.other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class GettingScreenshotsTest {

    private SeleniumServer seleniumServer;

    @Before
    public void doBefore() throws Exception {
        RemoteControlConfiguration config = new RemoteControlConfiguration();
        config.setPort(4444);
        config.setInteractive(false);
        seleniumServer = new SeleniumServer(config);
        seleniumServer.start();
    }

    @Test
    public void testTakeScreenshot() {
        Selenium browser = new DefaultSelenium("localhost", 4444, "*firefox3 c:\\sw\\Firefox\\firefox.exe", "http://www.google.de");

        browser.start();

        browser.open("/");

        browser.captureScreenshot("C:/screenshot.png");
    }

    @After
    public void doAfter() {
        seleniumServer.stop();
    }
}
