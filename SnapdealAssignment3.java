package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		//Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(mens).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		Thread.sleep(3000);
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(count);
		
		
		//training Shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		
		
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/following-sibling::ul/li[2]")).click();
		
		
		//Select the Price range
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1700");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(5000);
		//Filter the color
		
		driver.findElement(By.xpath("//input[@id='Color_s-Blue']/following-sibling::label")).click();
		//Applied Filters
		
		String filter1 = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div/a")).getText();
		System.out.println(filter1);
		Thread.sleep(5000);
		/*String filter2 = driver.findElement(By.xpath("(//div[@class='filters-top-selected']//div/following-sibling::div/a")).getText();
		System.out.println(filter2);*/
		
		//mouse over on the img
		WebElement product = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(product).perform();
		
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(2000);
		
		//take snap
		
				File source = driver.getScreenshotAs(OutputType.FILE);
				File destination = new File("./Snap/snapdealshoe.png");
				FileUtils.copyFile(source, destination);
				
		
		/*//Switch to New Window
		Set<String> newWindow = driver.getWindowHandles();
		List<String> Windows = new ArrayList<String>(newWindow);
		driver.switchTo().window(Windows.get(1));*/
		
		
		
		
		
		//driver.close();
		
		
		
		
		
		
		
	}

}
