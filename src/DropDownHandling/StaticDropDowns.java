package DropDownHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");		
        Thread.sleep(2000);
        WebElement staticDrop=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDrown =new Select(staticDrop);
		dropDrown.selectByIndex(3);
		System.out.println(dropDrown.getFirstSelectedOption().getText());
		dropDrown.selectByVisibleText("AED");
		System.out.println(dropDrown.getFirstSelectedOption().getText());
		dropDrown.selectByValue("INR");
		System.out.println(dropDrown.getFirstSelectedOption().getText());
		
		


		
		
        
        
	}

}
