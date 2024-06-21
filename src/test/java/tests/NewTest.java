package tests;

import org.testng.annotations.Test;

import utility.ExcelReading;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;

	ExcelReading excel = new ExcelReading();


	
  @Test
  public void f() throws Exception {
	  
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//input[@id='SearchProductName']")).sendKeys(excel.readExcel(1, 0, "product_nop"));
	  new Select(driver.findElement(By.xpath("//select[@id = 'SearchCategoryId']"))).selectByValue("3");
		new Select(driver.findElement(By.xpath("//select[@id = 'SearchManufacturerId']"))).selectByValue("1");
		new Select(driver.findElement(By.xpath("//select[@id ='SearchVendorId']"))).selectByValue("0");
		new Select(driver.findElement(By.xpath("//select[@id = 'SearchWarehouseId']"))).selectByValue("0");
		new Select(driver.findElement(By.xpath("//select[@id ='SearchProductTypeId']"))).selectByValue("5");
		new Select(driver.findElement(By.xpath("//select[@id ='SearchPublishedId']"))).selectByValue("1");
		driver.findElement(By.xpath("//input[@id ='GoDirectlyToSku']")).sendKeys("1800");
		

		driver.findElement(By.xpath("//button[@id ='search-products']")).click();

		
  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  driver = new ChromeDriver();

	  driver.manage().window().maximize();

	  driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();

	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
