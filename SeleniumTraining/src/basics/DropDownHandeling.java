package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownHandeling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.geodatasource.com/software/world-major-cities-drop-down-list-source-codes");
		WebElement dropDown = driver.findElement(By.id("countryCode"));
		Select select = new Select(dropDown);
		select.selectByValue("IN");
		
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='regionName']/option[@value='Goa']")));
		WebElement regionCode= driver.findElement(By.id("regionName"));
		Select selectRegion = new Select(regionCode);
		selectRegion.selectByValue("Goa");
//		Select select = new Select(dropDown);
//		select.selectByIndex(1);
//		select.selectByValue("AU");
//		select.selectByVisibleText("");

		
		
	}
}