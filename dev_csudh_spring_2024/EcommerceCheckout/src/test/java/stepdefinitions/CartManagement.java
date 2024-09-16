package stepdefinitions;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagement {
	
	Scanner scanner = new Scanner(System.in);
	WebDriver driver = null; 
	
	@Given("the user is logged in and on the {string} page")
	public void the_user_is_logged_in_and_on_the_product_page(String string) {
		
		System.out.println("Opening browser and logging into e-commerce account..."); 			// Display function actions
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Path is : " + projectPath);
	    System.setProperty("wedriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
	    
	    driver = new FirefoxDriver();															// Set driver to geckodriver
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); 						// Set timeout to 2 seconds to allow webpage to load
	    driver.navigate().to("https://www.amazon.com/"); 										// Load e-commerce site
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); 						// Set timeout to 2 seconds to allow webpage to load
	    
	    // Login to account for e-commerce website
	    driver.findElement(By.id("nav-link-accountList")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("anthonydaoy@gmail.com");
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("SidiousCode1997");
	    driver.findElement(By.id("signInSubmit")).click();
	    
	    // CODE TO HANDLE SECURITY CHECK
	    //if(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div")) != null) {
	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	    //}
	    
	    // Search for product
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(string);
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    
	    // Find and Click on first product 
	    driver.findElement(By.className("s-image")).click();
	     
	}

	@When("the user adds {int} of {string} to the cart")
	public void the_user_adds_of_to_the_cart(Integer int1, String string) {
	    
		driver.findElement(By.className("a-dropdown-container")).click();
		// Find quantity element and change amount
		driver.findElement(By.id("quantity_" + String.valueOf(int1 - 1))).click();
		
		driver.findElement(By.id("add-to-cart-button")).click();
	}

	@Then("the cart should contain {int} of {string}")
	public void the_cart_should_contain_of(Integer int1, String string) {
	    driver.findElement(By.id("sw-gtc")).click();
	    
	    if(String.valueOf(int1).equals(driver.findElement(By.className("a-dropdown-prompt")).getText())) {
	    	System.out.println("Product amount in cart equals amount given!!!"); 
	    }
	    else {
	    	System.out.println("Cart amount does not equal amount given!!!");
	    }
	    
	    driver.close();
	}

}
