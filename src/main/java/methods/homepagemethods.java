package methods;


import Utilities.FirstConfigFile;
import Utilities.ListFiles;
import Utilities.util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.rmi.server.MarshalOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class homepagemethods extends util {

    FirstConfigFile FC = new FirstConfigFile();
    ListFiles LF = new ListFiles();

    List<String> carRegValues;

    //repository for elements

    @FindBy(id = "vrm-input")
    public WebElement inputCarRegistration;


    @FindBy(css = "button.jsx-3653130054.inline.dual")
    public WebElement freeCarCheckButton;


    @FindBy(css = "#m > div > div:nth-child(3) > div.jsx-2530913122 > div > span > div.jsx-3529878979 > dl:nth-child(1) > dd")
    public WebElement carRegistration;

    @FindBy(css = "#m > div > div:nth-child(3) > div.jsx-2530913122 > div > span > div.jsx-3529878979 > dl:nth-child(2) > dd")
    public WebElement carMake;

    @FindBy(css = "#m > div > div:nth-child(3) > div.jsx-2530913122 > div > span > div.jsx-3529878979 > dl:nth-child(3) > dd")
    public WebElement carModel;

    @FindBy(css = "#m > div > div:nth-child(3) > div.jsx-2530913122 > div > span > div.jsx-3529878979 > dl:nth-child(4) > dd")
    public WebElement carColor;

    @FindBy(css = "#m > div > div:nth-child(3) > div.jsx-2530913122 > div > span > div.jsx-3529878979 > dl:nth-child(5) > dd")
    public WebElement carYear;




    public void ireadInputFileandExtractCarReg() throws IOException {

        List<String> v = LF.readalllocalfiles();
ArrayList<String>ar= new ArrayList<>();

        List<String> allRegValues = filterCarRegfromfile(v);
        try {


            for (String x : allRegValues) {
                System.out.println(x);
                enterCarRegNumber(x);

         Boolean decidingfactor= isElementPresent(By.xpath("//a[@class='jsx-3366286007 dual']"));



                if(decidingfactor){
                  ar.add(x+"failed<<<<<<<<<<<");
                    getDriver().navigate().back();
                }else{
                    compareSearchResults(x);
                    ar.add(x+"Passed<<<<<<<<<<<");
                    getDriver().navigate().back();
                }



            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        LF.writeoutputfile(ar);
        System.out.println(ar);
    }
    public boolean isElementPresent(By locator) {
        try {
            getDriver().findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }


    }
    public void enterCarRegNumber(String c) {


        waitforelementtoappear(inputCarRegistration);
        inputCarRegistration.sendKeys(c);
        clickFreeCarCheck();

    }

    public void clickFreeCarCheck() {


        waitforelementtoappear(freeCarCheckButton);
        freeCarCheckButton.click();


    }

    public void compareSearchResults(String c) {


        carRegValues = desiredCarRegDetails(readfile(FC.Outputfilepath), c);

        System.out.println(carRegValues + ">>>>>>>>>>");

        Assert.assertEquals(waitforelementtoappear(carRegistration).getText(), carRegValues.get(0));
        Assert.assertEquals(waitforelementtoappear(carMake).getText(), carRegValues.get(1));
        Assert.assertEquals(waitforelementtoappear(carModel).getText(), carRegValues.get(2));
        Assert.assertEquals(waitforelementtoappear(carColor).getText(), carRegValues.get(3));
        Assert.assertEquals(waitforelementtoappear(carYear).getText(), carRegValues.get(4));


    }




}







