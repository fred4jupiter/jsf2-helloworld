package org.openqa.selenium.example.base;

import org.openqa.selenium.server.SeleniumServer;

public class SeleniumServerControl {

    private static final SeleniumServerControl instance = new SeleniumServerControl();

    public static SeleniumServerControl getInstance() {
        return instance;
    }

    private SeleniumServer server = null;

    protected SeleniumServerControl() {
    }

    public void startSeleniumServer() {
        if (server == null) {
            try {
                server = new SeleniumServer();
                System.out.println(" selenium server " + server.toString());
            } catch (Exception e) {
                System.err
                        .println("Could not create Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
        try {
            server.start();
        } catch (Exception e) {
            System.err.println("Could not start Selenium Server because of: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopSeleniumServer() {
        if (server != null) {
            try {
                server.stop();
                server = null;
            } catch (Exception e) {
                System.err.println("Could not stop Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
