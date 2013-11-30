package org.openqa.selenium.example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SimpleHtmlUnitDriverTest {

    @Test
    public void testGoogleSearch() {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals("Cheese! - Google-Suche", driver.getTitle());
    }

    @Test
    public void testCallSimpleWithHtmlUnitDriver() throws Exception {

        HtmlUnitDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://localhost:8080/helloworld/");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("helloForm:username"));

        // Enter something to search for
        element.sendKeys("Michael");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        assertEquals("Response", driver.getTitle());

        WebElement head = driver.findElement(By.tagName("h2"));
        assertEquals("Hi, Michael", head.getText());
    }

}
