import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name="rahul";
		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	    String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password); 
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in.");
	    Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " +name+",");
	    driver.findElement(By.xpath("//*[@class='logout-btn']")).click();
	    System.out.println("logout successful");
	    driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click(); 
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passText= driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
           String[] passwordArray = passText.split("'");
       //index[0]=Please use temporary password  		   
       //index[1]='rahulshettyacademy' to Login.
       //String[] passwordArray2 =passwordArray[1].split("'");
       //index[0]=rahulshettyacademy  		   
       //index[1]=' to Login.
        //passwordArray2[0]      
          String password= passwordArray[1].split("'")[0];
           return password;
	}
}
