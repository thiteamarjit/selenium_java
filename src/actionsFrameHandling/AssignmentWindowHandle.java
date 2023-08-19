package actionsFrameHandling;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String mainWind = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(2000);
		Set<String> wins = driver.getWindowHandles();
		for (String w : wins) {
			System.out.println(w);
			if (!w.equals(mainWind)) { 
				driver.switchTo().window(w);
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.xpath("//h3[text()]")).getText());
			}
		}
		driver.switchTo().window(mainWind);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h3[text()]")).getText());

	}
}
