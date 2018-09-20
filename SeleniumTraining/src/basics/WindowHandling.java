package basics;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.icicibank.com");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		String iciciWindow = driver.getWindowHandle();
		WebElement popup = driver.findElement(By.id("push-modal-close"));
		if (popup.isDisplayed())
		{
			popup.click();
		}
		

		driver.findElement(By.xpath("//footer//a[text()='Share this Page']")).click();
		Thread.sleep(2000);
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowID : windowIds)
		{
			driver.switchTo().window(windowID);
			By by = By.name("email");
			if (isPresent(driver, by))
			{
				driver.findElement(by).sendKeys("abc@test.com");
				break;
			}
			
		}
		driver.switchTo().window(iciciWindow);
	}
public static boolean isPresent(WebDriver driver, By by)
{try {
		if(driver.findElement(by).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}}catch(NoSuchElementException e)
{
			return false;
}
}
}