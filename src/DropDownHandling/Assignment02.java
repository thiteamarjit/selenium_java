package DropDownHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment02 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("Amarjit");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys("amarjit@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("amarjit@gmail.com");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement selectGender=driver.findElement(By.id("exampleFormControlSelect1"));
        Select obj=new Select(selectGender);
        obj.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("02-07-1998");
        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
        Thread.sleep(2000);
        String Text= driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        System.out.println(Text);	
        if(Text.contains("Success! The Form has been submitted successfully!.")) {
        	driver.close();
        }
	}

}
