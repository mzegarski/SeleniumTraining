package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2SecondAlert{
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.globalsqa.com/samplepagetest");
	driver.findElement(By.xpath("//*[contains(text(),'Alert Box')]")).click();
	
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
	alert.accept();
	
	}
	
}