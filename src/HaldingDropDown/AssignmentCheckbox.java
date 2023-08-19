package HaldingDropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignmentCheckbox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
		//Checkbox validation
        checkboxValidation(driver);
        //checkboxCount 
        checkboxCount(driver);
        driver.close();
	}
	
	public static void checkboxValidation (WebDriver driver) {
		WebElement checkpoint1= driver.findElement(By.id("checkBoxOption1"));
		checkpoint1.click();
		 Assert.assertTrue(checkpoint1.isSelected(),"not checked");
		 checkpoint1.click();
		 Assert.assertFalse(checkpoint1.isSelected(),"not unchecked");		
	}
	public static void checkboxCount(WebDriver driver) {
		List<WebElement> listCheckbox= driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(listCheckbox.size());
	}	
}
