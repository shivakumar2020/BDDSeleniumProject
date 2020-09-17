package StepDefinination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	WebDriver driver;
	
	@Before 
	public void setUp(){ 
		
		WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver(); 
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   } 

    @Given("^Launch the Browser with provided url$")
    public void launch_browser() throws Throwable {
    	String url = "http://todomvc.com/examples/vue/";
    	driver.get(url);
    	System.out.print("in browser laucnh method");
    }


    @When("^Show Home Page$")
    public void show_home() throws Throwable {
        
       //verify navigate to home page
       Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'todos')]")).isDisplayed());
    }

  
    @Then("^Verify able to see todo list$")
    public void show_todo_list() throws Throwable {
    	//verify able to access item list
       Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).isEnabled());
    }

    
    @When("^Add \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"  to Todolist$")
    public void add_items_to_todolist(String strArg1, String strArg2, String strArg3) throws Throwable {
    

    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(strArg1);
    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);
    	
    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(strArg2);
    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);

    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(strArg3);
    	driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(Keys.ENTER);

    }

    @Then("^Verify the three items added to List$")
    public void verify_items_added_to_list() throws Throwable {
    	//verify the number of items added 
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'3')]")).isDisplayed());
     
    }
    
    @And("^Remove \"([^\"]*)\",\"([^\"]*)\" from Todolist$")
    public void remove_items_from_todolist(String strArg1, String strArg2) throws Throwable {
    	Actions actions = new Actions(driver);
    
    	if(driver.findElement(By.xpath("//label[contains(text(),'"+strArg1+"')]")).isDisplayed()) {
    	
    		//remove first item
    		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'"+strArg1+"')]"))).click().build().perform();
    		driver.findElement(By.xpath("//li[1]//div[1]//button[1]")).click();
    	}
    	
    	
       	if(driver.findElement(By.xpath("//label[contains(text(),'"+strArg2+"')]")).isDisplayed()) {
       		
       		//remove second item
       		actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'"+strArg2+"')]"))).click().build().perform();
    		driver.findElement(By.xpath("//li[1]//div[1]//button[1]")).click();
    	}
       	
    }
    
    @Then("^Verify the remaining items in to List$")
    public void verify_items_removed_to_list() throws Throwable {
    	//verify the remaining items in list after delete 
    	Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'1')]")).isDisplayed());
     
    }
    
  
    @After public void cleanUp(){ 
       driver.close(); 
    } 
	
}
