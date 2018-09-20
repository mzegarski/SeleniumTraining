package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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



public class Assignment5Peco1 {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.get("http://www.peco.com/");
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='My Account']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='Customer Support']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Customer Support']")));
		action.moveToElement(subMenu).click().perform();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void testCase1() throws IOException {
	driver.findElement(By.xpath("//span[text()='FAQs']")).click();
	takeScreenshot(driver, "FAQs");
	driver.navigate().back();
	
	}

	@Test(priority=2)
	public void testCase2() throws IOException {
	driver.findElement(By.xpath("//span[text()='Contact Us']")).click();
//	takeScreenshot("Contact");
	driver.navigate().back();
	}
	
	@Test(priority=3)
	public void testCase3() throws IOException {
		driver.findElement(By.xpath("//span[text()='Assistance Programs']")).click();
//		takeScreenshot("Assistance");
		driver.navigate().back();
	}
	
	@Test(priority=4)
	public void testCase4( ) throws IOException {
		driver.findElement(By.xpath("//span[text()='Equipment Responsibility']")).click();
//		takeScreenshot("Equipment");
		driver.navigate().back();
	}
	
	
	public void takeScreenshot(WebDriver driver, String pageType) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fName = new SimpleDateFormat(pageType+"'yyyyMMddHHmmss'.jpg'").format(new Date());
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.home") + "\\Desktop\\" + fName));
	}
}
