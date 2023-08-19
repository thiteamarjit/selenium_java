package DropDownHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBooking {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div")).click();
        driver.findElement(By.xpath("//div[@class=\"css-76zvg2 r-cqee49 r-ubezar r-1kfrs79\" and text()='Aurangabad']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and text()='Mumbai']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41' and text()='10']")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar' and text()='1 Adult']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[text()='2 Adults']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Search Flight']/following-sibling::div")).click();
	}

}
