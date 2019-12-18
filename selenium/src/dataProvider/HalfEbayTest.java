package dataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;

public class HalfEbayTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Material\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fin.ebay.com%2F");
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testdata=TestUtil.getDataFromExcel();
		return testdata.iterator();
	}
	@Test(dataProvider="getData")
	public void ebayRegistration(String fst_name, String lst_name, String mail, String pass_word) {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(fst_name);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lst_name);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(mail);
		
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(pass_word);
		
		driver.findElement(By.xpath("//input[@class='checkbox__control' and @type='checkbox' ]")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
