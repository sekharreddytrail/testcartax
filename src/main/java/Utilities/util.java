package Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
public class util extends webconnector {

    List<String> completefile;

    // waiting for element to appear
    public WebElement waitforelementtoappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        highLightElement(element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

    }


    public List<String> readfile(String outputfilepath) {

        try {
            completefile = Files.readAllLines(Paths.get(outputfilepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return completefile;

    }


    public List<String> desiredCarRegDetails(List<String> allLines, String carReg) {


        List<String> longnames = allLines.stream().skip(1).filter(x -> x.contains(carReg)).collect(Collectors.toList());

        List<String> cardetails = Arrays.stream(longnames.get(0).split(",")).collect(Collectors.toList());
        System.out.println(cardetails);

        return cardetails;
    }

    public List<String> readInputfile(String outputfilepath) {

        try {
            completefile = Files.readAllLines(Paths.get(outputfilepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return completefile;

    }
    public List<String> filterCarRegfromfile(List<String> allLines) {

        List<String> regnumbers = new ArrayList<>();
        List<String> newregnumbers = new ArrayList<>();
        String joined2 = String.join(",", allLines);


        Pattern pattern = Pattern.compile(" [A-Z]+[0-9]+[0-9]\\s+[A-Z]+[A-Z]+[A-Z]|[A-Z]+[0-9]+[0-9]+[A-Z]+[A-Z]+[A-Z]");

        Matcher matcher = pattern.matcher(joined2);
        while (matcher.find()) {
            regnumbers.add(matcher.group());
        }
        System.out.println(regnumbers+"OUTPUTOFWORDS");

        regnumbers.stream()
                .forEach(i -> {
                    if (i.contains(" ")) {
                        newregnumbers.add(i.replaceAll(" ", ""));

                    } else {
                        newregnumbers.add(i);
                    }
                });

        System.out.println(newregnumbers);

        return newregnumbers;


    }



    }
