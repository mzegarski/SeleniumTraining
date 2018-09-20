package testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AssessmentTestCases {

	WebDriver driver;
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.get("http://www.amazon.in/");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void testCase1() throws InterruptedException {
		WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
		WebElement mensFashion = driver.findElement(By.cssSelector("span[aria-label*='Men']"));
		WebElement mensClothing = driver.findElement(By.cssSelector("a[href*='Mens-Clothing']"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label*='Men']")));
		action.moveToElement(mensFashion).perform();
		WebDriverWait wait2 = new WebDriverWait(driver, 30l);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='Mens-Clothing'")));
		action.moveToElement(mensClothing).click().perform();
		String expectedTitle = "Mens' Wear: Buy Mens' Clothes online at best prices in India - Amazon.in";
		Assert.assertEquals(expectedTitle, driver.getTitle());
		}

	@Test
	public void testCase2() throws InterruptedException {
		driver.findElement(By.cssSelector("input[class='nav-input'][tabindex='6']")).sendKeys("tshirt");
		driver.findElement(By.cssSelector("input[type='submit'][tabindex='7']")).click();
		List<WebElement> allElements = driver.findElements(By.xpath("//a/h2"));
	     for(WebElement element: allElements)
	    {
	    	String eleLower = element.getText().toLowerCase();
	    	if(eleLower.contains("t shirt") || eleLower.contains("t-shirt") || eleLower.contains("tshirt")) 
	       {
	       }else
	       {Assert.fail();
	       }
	    }
		
	}
}

