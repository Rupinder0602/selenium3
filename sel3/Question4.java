package sel3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


public class Question4 {
	public WebDriver driver;
	public Actions action;
	
	@BeforeTest
	public void launch() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rupinder Kaur\\eclipse-workspace\\sel3\\src\\main\\resources\\chromedriver.exe");
	

	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(" https://www.tothenew.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	action = new Actions(driver);
	}
//	@Test
//	public void TTN_scroll_method1() {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,1000)");
//	}
//	@Test
//	public void TTN_scroll_method2() {
//		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@id='block-views-block-related-success-stories-block-5']/div/div/div/div[1]/div/div")));
//	}
	@Test
	public void TTN_scroll_method3() {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	@AfterMethod
	public void Close() {
	driver.close();
	}
	

}

