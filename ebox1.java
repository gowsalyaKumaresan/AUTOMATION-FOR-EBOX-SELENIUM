package PROGRAM;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ebox1 {
	private WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	
	public static String baseUrl = "https://hcl.e-box.co.in/";;
	@BeforeTest
	public void setUp() throws Exception {
		reporter = new ExtentHtmlReporter("Bavani.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bavani\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	@Test
	public void testWeb() throws Exception {
		ExtentTest test = reports.createTest("hema", "Sample Description");
			driver.get(baseUrl);
			
			System.out.println(driver.getTitle());
			driver.manage().window().maximize();
			
			
			//Login
			driver.findElement(By.name("username")).sendKeys("PL0521004");
			
			driver.findElement(By.name("password")).sendKeys("welcome123");
			driver.findElement(By.id("login-submit")).click();
			if(driver.getCurrentUrl().contains("https://hcl.e-box.co.in/course/coursetabs"));
			{
				test.log(Status.PASS, "PASS");
			}

			
			//scroll down
			WebElement fromElement = driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[3]/div[1]/h3"));

			 //WebElement to which the above object is dropped
			 WebElement toElement = driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[3]/div[4]/div[5]/div/div[2]/div[1]/div[1]/h2"));

			 //Creating object of Actions class to build composite actions
			 Actions builder = new Actions(driver);

			 //Building a drag and drop action
			 Action dragAndDrop = builder.clickAndHold(fromElement)
			.moveToElement(toElement)
			.release(toElement)
			.build();

			 //Performing the drag and drop action
			   dragAndDrop.perform();
			
			  //common testing
			   driver.findElement(By.xpath("//p[contains(text(),'OC COMMON TESTING')]")).click();
			  
			  
			  //topic1 
			  
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div/ul[1]/li/div/div[2]/p")).click() ;
			  
			  //i explore 
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[1]/ul/li[2]/div")).click(); 
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[2]/div/ul/li/div/div[2]/a/h4")).click(); 
			  driver.navigate().back();
			  
			  //i practice 1Q 
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[1]/ul/li[4]/div")).click();
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[2]/div/ul/li/div/div[2]/a/h4")).click(); 
			  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div/a")).click();
			  driver.navigate().back();
			  driver.navigate().back();
			  
				
			  //additional Bridges2
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[1]/ul/li[6]/div")).click();
			  driver.findElement(By.xpath( "/html/body/div[1]/section/div[3]/div[2]/div[1]/div[2]/div/ul/li[1]/div/div[2]/a/h4")).click();
			  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/div/a")).click(); 
			  driver.navigate().back();
			  driver.navigate().back();
				  
			  //additional hots3 
			  driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div[2]/div/ul/li[2]/div/div[2]/a/h4")).click();
		      driver.findElement(By.xpath( "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div/div/div[3]/div/a" )).click();
				 
			  
			  System.out.println(driver.getCurrentUrl());
			 
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		reports.flush();
	}

}