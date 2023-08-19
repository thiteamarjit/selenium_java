import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractice { 

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Users\\amarjit\\eclipse-workplace\\Introduction\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		String userName = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[1]")).getText().trim();
		String passWord = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText().trim();
		System.out.println("userName: "+userName+" and Password: "+passWord );
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//label[@class='customradio'][2]/span[@class='checkmark']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("okayBtn"))));
		driver.findElement(By.id("okayBtn")).click();
		Select sele=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		sele.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		orderItem(driver,wait); 
	}
	
	public static void orderItem(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='card h-100']//h4[@class='card-title']/a"))));
		List<WebElement> itemsList=driver.findElements(By.xpath("//div[@class='card h-100']//h4[@class='card-title']/a"));
		for(int i=0; i<itemsList.size(); i++) {
			System.out.println(i+1+")"+itemsList.get(i).getText());
			driver.findElements(By.xpath("//div[@class='card h-100']//button")).get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();	
	}
}
