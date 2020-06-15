package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HeadDriver {

    public WebDriver driver = null;
    public EventFiringWebDriver e_driver;
    public WebEventListener eventListener;


    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();


    public void setWebDriver(WebDriver driver) {

        dr.set(driver);
    }

    public WebDriver getDriver() {

        return dr.get();

    }


}
