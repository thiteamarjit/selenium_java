import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPlace {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 5);

		String[] itemsList = { "Brocolli", "Beetroot", "Cucumber", "Carrot", "Beans" };
		itemOrder(driver, itemsList);
		driver.findElement(By.xpath("//div[@class='cart-info']//following-sibling::a")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		WebElement ele= driver.findElement(By.cssSelector("input.promoCode"));
		ele.sendKeys("amarjitThite");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		String promoInfo= driver.findElement(By.cssSelector("span.promoInfo")).getText();
		
		if(promoInfo.contains("Invalid")) {
			ele.clear();
			ele.sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector("button.promoBtn")).click();
			wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.promoInfo")), "applied"));
			System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		}
		
	}

	public static void itemOrder(WebDriver driver, String[] itemsList) {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText().split("-")[0].trim();
			System.out.println(i + 1 + ") productName:" + productName);
			List<String> itemsNeededlist = Arrays.asList(itemsList); 
			if (itemsNeededlist.contains(productName)) {
				driver.findElements(By.xpath("//button[contains(text(),'ADD')]")).get(i).click();
				j++;
				if (j == itemsList.length) {
					break;
				}
			}
		}
	}
	
	public static void itemInCart() {
		
	}
}
