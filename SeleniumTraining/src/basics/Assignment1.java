package basics;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	public static void main(String[] args) throws FileNotFoundException {

//Set up the properties and launch the page.
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");

//Navigate to the Registration page
		driver.findElement(By.linkText("Register here")).click();

//Populate all of the fields.		
		driver.findElement(By.name("firstName")).sendKeys("Matt");
		driver.findElement(By.name("lastName")).sendKeys("Zegarski");
		driver.findElement(By.name("phone")).sendKeys("267-555-3232");
		driver.findElement(By.name("userName")).sendKeys("thezman@mailinator.com");
		driver.findElement(By.name("address1")).sendKeys("2501 Main St.");
		driver.findElement(By.name("address2")).sendKeys("Apt 1");
		driver.findElement(By.name("city")).sendKeys("Philadelphia");
		driver.findElement(By.name("state")).sendKeys("PA");
		driver.findElement(By.name("postalCode")).sendKeys("19037");
		WebElement dropDown = driver.findElement(By.name("country"));
		Select select = new Select(dropDown);
		select.selectByValue("215");
		
		
//Creates new file, and prints the timestamp so we know when the test ran.
		String fName = new SimpleDateFormat("'LoginInfo'yyyyMMddHHmmss'.txt'").format(new Date());
		PrintStream out = new PrintStream (System.getProperty("user.home") + "\\Desktop\\" + fName);
		Date date = new Date();
		out.println(date);
		
//Enters the username and sends it to the file.		
		driver.findElement(By.name("email")).sendKeys("thezman@mailinator.com");
		out.println(driver.findElement(By.name("email")).getAttribute("value"));
	

//Enters the password and sends it to the file.
		driver.findElement(By.name("password")).sendKeys("Test123");
		out.println(driver.findElement(By.name("password")).getAttribute("value"));
		
//Enters the confirm password and submits the registration.		
		driver.findElement(By.name("confirmPassword")).sendKeys("Test123");
		driver.findElement(By.name("register")).click();
		
//Clean up
		out.close();
		driver.close();
					
	}
}