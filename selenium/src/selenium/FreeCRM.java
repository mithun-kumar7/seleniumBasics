package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCRM {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Material\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.freecrm.com");
		driver.findElement(
				By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		driver.findElement(By.name("email")).sendKeys("mithunkr0123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("mi321");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(5000);
		driver.close();
	}

}
