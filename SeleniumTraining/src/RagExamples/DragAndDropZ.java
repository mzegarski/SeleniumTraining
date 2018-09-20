package RagExamples;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropZ {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.globalsqa.com/demo-site/draganddrop/");
		
		//Wait for an element to load within 30 seconds
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src = driver.findElement(By.xpath("//ul[@id='gallery']/li[1]"));
		WebElement dest = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
		

	}
}

