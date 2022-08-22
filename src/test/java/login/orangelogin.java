package login;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;



public class orangelogin {
	
	WebDriver driver;
	@Given("user lanunch the browser")
	public void user_lanunch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	   
	}

	@When("user open url")
	public void user_open_url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	}

	@When("enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		
	    
	}

	@When("login into the page")
	public void login_into_the_page() {
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	}

	@Then("verify the data")
	public void verify_the_data() {
	 String nv = driver.getTitle();
	Assert.assertEquals("OrangeHRM", nv);
	
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	    
	}


}
