package StepsDefinitions;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CsudhCanvasLogin {
	
	Scanner scanner = new Scanner(System.in); 	// Create Scanner object to input Duo Passcode
	
	WebDriver driver = null;
	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
		System.out.println("Open browser to CSUDH Canvas login page");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Path is :" + projectPath);
		
		System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		// Set timeout to 2 seconds to allow webpage to load
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.navigate().to("https://canvas.csudh.edu/");
	}

	@When("the user enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() throws InterruptedException {
		driver.findElement(By.id("user")).sendKeys("adao4");
		driver.findElement(By.id("pass")).sendKeys("TavSha9478bg#");
		
		Thread.sleep(2000);
	}

	@And("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		driver.findElement(By.id("submit")).click();
		
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[2]/div[6]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[1]/ul/li[2]/a/span[3]")).click();
		
		Thread.sleep(2000);
		
		System.out.print("Enter Duo passcode: ");
		String passCode = scanner.nextLine();
		driver.findElement(By.id("passcode-input")).sendKeys(passCode);
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[2]/form/div[3]/button")).click();
		
		System.out.println("Entering passcode...");
		
	}

	@And("a welcome message should be displayed")
	public void a_welcome_message_should_be_displayed() {
		driver.findElement(By.id("trust-browser-button")).click();
		System.out.println("Welcome to the CSUDH Canvas!");
	}
}
