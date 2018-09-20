package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInToIndeed {
	
	WebDriver driver;
	@BeforeMethod
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.get("http://www.indeed.com/");
	}
	
	
	@AfterMethod
	public void tearDown() {
//		driver.navigate().to("http://www.indeed.com");
//		driver.findElement(By.cssSelector("span[class='gb_ab gbii']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	driver.close();
	}
	
	@Test(priority=1)
	public void loginFail() {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.cssSelector("input[id='signin_email']")).sendKeys("borntofail@bad.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("wontlogin");

//Find out how to get the value of the check box.
//		WebElement checkboxChecked = driver.findElement(By.cssSelector("input[type='checkbox']"));
//		System.out.println(checkboxChecked);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String expectedError = "Incorrect password or email address";
		WebElement ele = driver.findElement(By.xpath("//div[@id='signin_password_grp']/div[@class='control-error']"));		
		Assert.assertEquals(expectedError, ele.getText());
	}
	
	@Test(priority=2)
	public void loginPass() throws InterruptedException {
		String loginEmail = "thezman@mailinator.com";
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.cssSelector("input[id='signin_email']")).sendKeys(loginEmail);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span/b")));
		WebElement actualLogin = driver.findElement(By.xpath("//span/b"));
		if (actualLogin.getText().equals(loginEmail)) {
			driver.findElement(By.cssSelector("span[class='gb_ab gbii']")).click();
			driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		}else {
			Assert.fail();
		}
	}
}
