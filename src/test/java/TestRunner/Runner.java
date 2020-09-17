package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue="StepDefinination")	
public class Runner extends AbstractTestNGCucumberTests {

	
}
