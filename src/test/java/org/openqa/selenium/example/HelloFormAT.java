package org.openqa.selenium.example;

import helloworld.Application;
import helloworld.JettyRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;

public class HelloFormAT {

    private static final String URL = "http://localhost:8080/helloworld/index.html";

    private static org.eclipse.jetty.server.Server jettyServer = null;

    @BeforeClass
    public static void startJetty() throws Exception {
        jettyServer = JettyRunner.startJetty(Application.class);
    }

    @AfterClass
    public static void stopJetty() {
        JettyRunner.stopJetty(jettyServer);
    }

    @Test
    public void testCallSimpleWithHtmlUnitDriver() throws Exception {
        HtmlUnitDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get(URL);

        // Find the text input element by its name
        WebElement firstNameElement = driver.findElement(By.id("helloForm:firstname"));
        firstNameElement.sendKeys("Fred");

        WebElement lastNameElement = driver.findElement(By.id("helloForm:lastname"));
        lastNameElement.sendKeys("Feuerstein");

        // Now submit the form. WebDriver will find the form for us from the element
        lastNameElement.submit();
        assertEquals("Response", driver.getTitle());

        WebElement head = driver.findElement(By.tagName("h3"));
        assertEquals("Hello Fred Feuerstein from composite!", head.getText());
    }
}
