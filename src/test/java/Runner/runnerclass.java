package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


//running the project from runner class

@RunWith(Cucumber.class)
@CucumberOptions(
        // define output files
        plugin = {"pretty", "html:target/cucumber"},
        //location of feature files containing tests
        features = "src/test/resource/",
        strict = true,
        monochrome = true,
        //location of steps for files
        glue = {"StepDefinitions"}
)

public class runnerclass {

}

