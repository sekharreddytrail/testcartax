package StepDefinitions;

import Utilities.util;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.homepagemethods;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class homepagestepdefs extends util {

    //creating object for methods
    public homepagemethods homepage_method;

    //contructor initialising config file and homepage method
    public homepagestepdefs() throws IOException {

        intialise();
        homepage_method = PageFactory.initElements(open_browser(), homepagemethods.class);

    }


    @Before()
    public void firstbefore() {
        System.out.println("BEFORE STEP");

    }

    //quiting browser
    @After()
    public void firstafter() {
        quitbrowser();
    }

    //opening browser and navigating to website
    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        gotowebsite();

    }




    @When("^I enter each car registration number$")
    public void iEnterEachCarRegistrationNumber() {
        //  homepage_method.enterCarRegNumber();

    }

    @Then("^I compare search results with output file$")
    public void iCompareSearchResultsWithOutputFile() {
        //  homepage_method.compareSearchResults();
    }


    @Given("^Read Inputfile and extract the Car Registration numbers and compare results$")
    public void readInputfileAndExtractTheCarRegistrationNumbersAndCompareResults() throws IOException {
        homepage_method.ireadInputFileandExtractCarReg();
    }
}
