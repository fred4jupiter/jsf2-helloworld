package org.openqa.selenium.example;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxTest {

    private FirefoxDriver driver;

    @Before
    public void doBeforeTest() throws Exception {
        File firefoxExe = new File("c:/SW/Firefox/firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxExe);
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(firefoxBinary, profile);
    }

    @Test
    public void testCallSimple() throws Exception {

        // Seite aufrufen
        driver.get("http://localhost:8080/helloworld/");

        // Textfeld selektieren
        WebElement element = driver.findElement(By.id("helloForm:username"));

        // Text eingeben
        element.sendKeys("Michael");

        saveScreenShot("c://screenshotPage1.png", driver);

        // auf 'submit' klicken
        driver.findElement(By.id("helloForm:submit")).click();

        // pruefen, ob auf der naechsten Seite im Titel Response steht
        assertEquals("Response", driver.getTitle());

        // Antwort pruefen
        assertEquals("Hi, Michael", driver.findElement(By.tagName("h2")).getText());

        saveScreenShot("c://screenshotPage2.png", driver);
    }

    private void saveScreenShot(String pathFileName, FirefoxDriver firefoxDriver) {
        try {
            OutputStream out = new FileOutputStream(new File(pathFileName));
            out.write(firefoxDriver.getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
