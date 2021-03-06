package helloworld.web;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class HelloFormAT {

    private static final Logger LOG = LoggerFactory.getLogger(HelloFormAT.class);

    // this is the test server
    private static final String URL = "http://localhost:9090/jsf2-helloworld/";

    @Test
    public void testCallSimpleWithHtmlUnitDriver() throws Exception {
        HtmlUnitDriver driver = new HtmlUnitDriver();

        LOG.debug("try to call URL=" + URL);

        driver.get(URL);

        // Find the text input element by its name
        WebElement firstNameElement = driver.findElement(By.id("helloForm:firstname"));
        assertNotNull(firstNameElement);
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
