package realTimePractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Users\\\\amarjit\\\\eclipse-workplace\\\\Introduction\\\\resources\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		Thread.sleep(2000);
		//October 23	
		while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("October")){
              System.out.println(driver.findElement(By.xpath("//span[@class='cur-month']")).getText());
              driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[local-name()='svg']")).click();
              Thread.sleep(2000);
		     }
		Thread.sleep(5000);
		List<WebElement> dates=driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		int count = dates.size();
		for(int i=0; i<count; i++) {
		String day=dates.get(i).getText();
		System.out.println(day);
			if(day.equalsIgnoreCase("23")) {
			dates.get(i).click();
			break; 
			}
		}
	}
}
