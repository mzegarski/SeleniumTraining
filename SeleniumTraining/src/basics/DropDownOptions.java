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

public class DropDownOptions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.geodatasource.com/software/world-major-cities-drop-down-list-source-codes");
		WebElement dropDown = driver.findElement(By.id("countryCode"));
		Select select = new Select(dropDown);
		
		List<WebElement> ele = select.getOptions();
//		for(int i=0; i<ele.size();i++) 
//		{
//			System.out.println(x);
//		}
//		
//	}
	}
}
