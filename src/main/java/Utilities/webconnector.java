package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class webconnector extends DriverClass {

    // intitalising files and driver

    DriverClass dc = new DriverClass();
    FirstConfigFile FC = new FirstConfigFile();


    // intialise the config file

    public void intialise() throws IOException {

        FC.preFirstIntialise();
    }


    /////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////


    public WebDriver open_browser() {
        System.out.println("openin brwer");


        if (driver == null) {

            // firefox browser
            if (FC.getBrowser.equalsIgnoreCase("Firefox") && FC.getLocation.equalsIgnoreCase("local")) {
                WebDriverManager.firefoxdriver().clearPreferences();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                setWebDriver(driver);

                // Chrome browser
            } else if (FC.getBrowser.equalsIgnoreCase("chrome") && FC.getLocation.equalsIgnoreCase("local")) {

                dc.chromecap();


            }

        }

        return getDriver();
    }


    public void gotowebsite() {
        System.out.println("OPENING website");


        if (!getDriver().getCurrentUrl().contains("cartaxcheck")) {
            System.out.println("goingtoweb");
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().get(FC.getURL);

        }


    }


    // quit browser
    public void quitbrowser() {
        getDriver().quit();
    }

}
