package realTimePractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get the links count on page
		driver.get("http://qaclickacademy.com/practice.php");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String linkValue = link.getAttribute("href");
			//System.out.println(linkValue);
		}
		
		//footerLinksCount
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerSection.findElements(By.tagName("a")).size());
		
		//footerLink 1st column 
		WebElement column =driver.findElement(By.xpath("//div[@id='gf-BIG']//tr/td[1]/ul"));
		List<WebElement>ele =column.findElements(By.tagName("a"));
		
		for(int i=0; i<ele.size(); i++) {
			
			String contrlClick= Keys.chord(Keys.CONTROL,Keys.ENTER);
			ele.get(i).sendKeys(contrlClick);
			Thread.sleep(5000);
		}
		
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it= windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	
	}

}
