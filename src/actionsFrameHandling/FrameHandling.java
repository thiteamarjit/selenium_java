package actionsFrameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
	    driver.switchTo().frame(driver.findElement(By.name("frame-top")));
	    driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
