package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingDetails {
	
	WebDriver driver = null;
	
	@Given("the user has product\\(s) in cart and is on the checkout page")
	public void the_user_has_product_s_in_cart_and_is_on_the_checkout_page() throws InterruptedException {
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
	    
	    // Find and click on shopping cart then go to checkout
	    driver.findElement(By.id("nav-cart")).click();
	    driver.findElement(By.className("a-button-input")).click();
	    
	   
		Thread.sleep(4000);
	
	    // Find and click on the shipping address element
	    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]/span/h3")).click();
	    Thread.sleep(9000);
	}

	@When("the user fills out {string}, {string}, {int}, {string}, {string}, {string}, {int}")
	public void the_user_fills_out(String string, String string2, Integer int1, String string3, String string4, String string5, Integer int2) throws InterruptedException {
		driver.findElement(By.id("shipToThisAddressButton")).click();
		
	}

	@Then("the shipping address should contain {string}, {string}, {int}, {string}, {string}, {string}, {int}")
	public void the_shipping_address_should_contain(String string, String string2, Integer int1, String string3, String string4, String string5, Integer int2) {
		
	}
}
