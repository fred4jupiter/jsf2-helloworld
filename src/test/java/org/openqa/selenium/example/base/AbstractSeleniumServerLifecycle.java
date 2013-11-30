package org.openqa.selenium.example.base;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractSeleniumServerLifecycle {

    @Before
    public void doBeforeTest() {
        SeleniumServerControl seleniumServerControl = SeleniumServerControl.getInstance();
        seleniumServerControl.startSeleniumServer();
    }

    @After
    public void doAfterTest() {
        SeleniumServerControl seleniumServerControl = SeleniumServerControl.getInstance();
        seleniumServerControl.stopSeleniumServer();
    }
}
