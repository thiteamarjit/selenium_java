package realTimePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment95lect {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Users\\\\amarjit\\\\eclipse-workplace\\\\Introduction\\\\resources\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		String text = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(text);
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert();
		Thread.sleep(2000);
		if (driver.switchTo().alert().getText().contains(text)) {
			driver.switchTo().alert().accept();
			driver.quit();
		}
	}

}
