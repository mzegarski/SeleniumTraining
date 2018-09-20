package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.timeanddate.com");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		
		WebElement menu = driver.findElement(By.xpath("//li/a[text()='World Clock']"));
		WebElement submenu = driver.findElement(By.xpath("//li/a[text()='Extended World Clock']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		action.moveToElement(submenu).click().perform();
		String h1Tag = driver.findElement(By.tagName("h1")).getText();
		System.out.println(h1Tag);	
	}

}
