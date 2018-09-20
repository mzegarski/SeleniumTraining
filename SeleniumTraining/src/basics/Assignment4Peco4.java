package basics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4Peco4 {

	public static void main(String[] args) throws InterruptedException, IOException{
//Setup test		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.peco.com/");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
//Navigate to Electric Vehicle Basics.
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='Smart Energy']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='Electric Vehicles']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Electric Vehicles']")));
		action.moveToElement(subMenu).click().perform();
		driver.findElement(By.xpath("//h2[text()='EV Basics']")).click();
//Verify that the link takes the user to an external page.
		driver.findElement(By.cssSelector("a[href='https://www.advancedenergy.org/electrictransportation/']")).click();
		Thread.sleep(2000);
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowID : windowIds)
		{
			driver.switchTo().window(windowID);
			By by = By.xpath("");
//		if (isPresent(driver, by))
//			{
//				break;
//			}
			
		}
		//driver.switchTo().window();
	}

	
//	public static boolean isPresent(WebDriver driver, By by)
//{try {
//		if(driver.findElement(by).isDisplayed())
//		{
//			return true;
//		}else
//		{
//			return false;
//		}}catch(NoSuchElementException e)
//	}

}
