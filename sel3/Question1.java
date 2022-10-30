package sel3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class Question1 {

	public WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rupinder Kaur\\eclipse-workspace\\sel3\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test(priority = 1)
	public void FillTextBox() {
		WebElement first_name = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
		first_name.sendKeys("Rupinder");

		WebElement last_name = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
		last_name.sendKeys("Kaur");
		WebElement mail = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
		mail.sendKeys("rupinderdhiman@gmail.com");
		WebElement address = driver.findElement(By.xpath("//*[@ng-model='Adress']"));
		address.sendKeys("Patiala");
		WebElement Phone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
		Phone.sendKeys("9914696409");
		WebElement Pass1 = driver.findElement(By.xpath("//input[@id='firstpassword']"));
		Pass1.sendKeys("pass123");
		WebElement Pass2 = driver.findElement(By.xpath("//input[@id='secondpassword']"));
		Pass2.sendKeys("pass123");
	}

	@Test(priority = 2)
	public void HandleRadioAndCheckbox() {
		// Check all Hobbies

		List<WebElement> Hobbies =

				driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < Hobbies.size(); i++) {
			Hobbies.get(i).click();
		}
		// Select Male Radio Button
		List<WebElement> Gender = driver.findElements(By.xpath("//input[@type='radio']"));
		Gender.get(0).click();

		boolean GenderSelect =

				driver.findElement(By.xpath("//input[@value='Male']")).isSelected();
		Assert.assertTrue(GenderSelect);
	}

	@Test(priority = 3)
	public void HandleDropdowns() {
		WebElement Skills = driver.findElement(By.id("Skills"));
		Select se = new Select(Skills);
		se.selectByVisibleText("Java");

		WebElement SelectCountry = driver.findElement(By.id("country"));
		se = new Select(SelectCountry);
		se.selectByVisibleText("India");

		driver.findElement(By.id("msdd")).click();
		List<WebElement> Language = driver.findElements(By

				.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		Language.get(7).click();

		WebElement Year = driver.findElement(By.id("yearbox"));
		se = new Select(Year);
		se.selectByVisibleText("1998");

		WebElement Month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		se = new Select(Month);
		se.selectByVisibleText("April");

		WebElement Day = driver.findElement(By.id("daybox"));
		se = new Select(Day);
		se.selectByVisibleText("19");
	}

	@Test(priority = 4)
	public void Submit() {
		WebElement SubmitBtn = driver.findElement(By.id("submitbtn"));
		SubmitBtn.click();
	}
	@AfterTest
	public void quit() {
//		driver.manage().timeouts().implicitlyWait(2000,null);
		driver.quit();
	}
}
