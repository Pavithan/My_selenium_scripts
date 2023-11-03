import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.util.*;


public class sel_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Open website HOMEPAGE
		
		driver.get("https://www.iascertification.com/");
		
		Thread.sleep(2000); //Not effective way of giving WAIT, always implicit wait.
		
		List<WebElement> menus = driver.findElements(By.cssSelector("li a"));
		
		String fil_menu = "Contact us";
		
		//Iterate through menu and find TEXT for effective selection of menu.
		
		for(WebElement menu : menus) 
		{
			if(menu.getText().equalsIgnoreCase(fil_menu))
			{
				menu.click();
				break;
			}
		}
		
		//Contact US form
	
		Thread.sleep(5000);
		
		driver.findElement(By.name("title")).sendKeys("Mr.");
		driver.findElement(By.name("your-name")).sendKeys("ABC");
		driver.findElement(By.name("company-name")).sendKeys("IASEAS");
		driver.findElement(By.name("Job-Title")).sendKeys("Tester");
		driver.findElement(By.name("country")).sendKeys(" ");
		driver.findElement(By.name("phone_no")).sendKeys("+919876543210");
		driver.findElement(By.name("email")).sendKeys("testxemo@yopmail.com");
		
		//DropDown
		driver.findElement(By.cssSelector("span[data-name='enquiry-type']")).click();
		driver.findElement(By.cssSelector(".select2-results__options :nth-child(3)")).click();
		
		driver.findElement(By.name("remarks")).sendKeys("This is a test message");
		driver.findElement(By.cssSelector("input[value='1']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("input[value='Send']")).click();
		Thread.sleep(5000);
		
		WebElement h2 = driver.findElement(By.cssSelector(".h2"));
		String str = h2.getText();
		Assert.assertEquals("Form Submission Success!", str);

	}

}
