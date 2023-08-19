package actionsFrameHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver" , "F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		String parentId=it.next();
		String childId = it.next();
		driver.switchTo().window(childId);	
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId); 
		driver.findElement(By.id("username")).sendKeys(emailId);
	
	}

}
