package selenium.Test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/dynamic-properties");
		
		driver.findElement(By.cssSelector(".element-list.collapse.show")); // This can be the answer for Q9. Using driver.findElement
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		
		// LINK Test click and verify
		driver.findElement(By.xpath("(//li[@id='item-5'])[1]")).click();
		//js.executeScript("window.scroll(0,200)");
		driver.findElement(By.linkText("Created")).click();
		Thread.sleep(2000);
		//Assert.assertEquals(driver.findElement(By.cssSelector("#linkResponse")).getText(), "Link has responded with staus 201 and status text Created");

		//Enter Text in TextBox
		js.executeScript("window.scroll(0,100)");
		driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
		driver.findElement(By.id("userName")).sendKeys("Pavithran");
		driver.findElement(By.id("userEmail")).sendKeys("sripavithran99@gmail.com");
		
		//IFrames
		js.executeScript("window.scroll(0,1000)");
		driver.findElement(By.xpath("(//div[@class='header-right'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@id='item-2'])[2]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
		String getframetext = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(getframetext, "This is a sample page");
		driver.switchTo().defaultContent();
		
		//Window Iteration
		driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();
		driver.findElement(By.cssSelector("#tabButton")).click();
		Thread.sleep(3000);
		String originalwindow = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();
		
		for(String windownhandle : window) {
			
			if(!windownhandle.equals(originalwindow)) {
				
				driver.switchTo().window(windownhandle);
				break;
				
			}

		}
		
		driver.close();
		driver.switchTo().window(originalwindow);
		
		//DropDown
		driver.findElement(By.xpath("(//div[@class='header-right'])[2]")).click();
		driver.findElement(By.xpath("(//li[@id='item-0'])[2]")).click();
		js.executeScript("window.scroll(0,600)");
		
		List<WebElement> dropdown = driver.findElements(By.cssSelector(".css-1hwfws3 .css-1wa3eu0-placeholder"));
		for(WebElement dd : dropdown) {
			
			if(dd.getAttribute("style").equalsIgnoreCase("Select State")) {
				
				dd.click();
				break;
				
			}

		}
		Actions acnt = new Actions(driver);
		acnt.sendKeys("UT", Keys.ENTER).build().perform();
		
		//Drag and Drop
		driver.findElement(By.xpath("(//div)[45]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,1000)");
		driver.findElement(By.xpath("(//li[@id='item-3'])[4]")).click();
		
		WebElement sourceElement = driver.findElement(By.cssSelector("#draggable"));
		WebElement targetElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}

}
