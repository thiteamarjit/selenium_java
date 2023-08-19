package alertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {

		String Text="Amarjit";
		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
		
        driver.findElement(By.id("name")).sendKeys(Text);
        driver.findElement(By.id("alertbtn")).click();	
        String alertText= driver.switchTo().alert().getText();
        System.out.println(alertText);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
       Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        
        
		
	}

}
