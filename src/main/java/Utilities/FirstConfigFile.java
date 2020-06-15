package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FirstConfigFile {

    public String browser = null;
    public FileInputStream configfile = null;
    public Properties prop = null;
    public String filepath = "src/main/java/resource/Config.properties";
    public String getBrowser;
    public String getLocation;
    public String getURL;
    public String Outputfilepath = "src/main/java/resource/car_output.txt";
    public String Inputfilepath = "src/main/java/resource/car_input.txt";

    public void preFirstIntialise() throws IOException {
        configfile = new FileInputStream(filepath);

        prop = new Properties();
        prop.load(configfile);
        setbrowser();
        setLocation();
        setURL();
        System.out.println("intialised");
    }


    public void setbrowser() {
        this.getBrowser = prop.getProperty("browser");

    }


    public void setLocation() {
        this.getLocation = prop.getProperty("location");

    }


    public void setURL() {
        this.getURL = prop.getProperty("url");

    }


}
