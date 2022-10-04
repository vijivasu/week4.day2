package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		
		//Search brands
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();
		String Title = driver.getTitle();
		System.out.println(Title);
		
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//Category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='arrow-icon']/preceding::span[text()='Hair Care']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
		
		//concern
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//Check condition - Filter Applied
		
		String filterDetails = driver.findElement(By.xpath("//div[@class='css-rtde4j'] //span")).getText();
		
		if(filterDetails.contains("Shampoo")) {
			System.out.println("Verified - Product Applied");
		}else {
			System.out.println("Not Verified");
		}
		
		//Click on Shampoo
		driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"] ")).click();
		
		//New Window
		
		Set<String> newWindow = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(newWindow);
		driver.switchTo().window(window.get(1));
		
		//Seclect size from Dropdown
		WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd = new Select(size);
		dd.selectByIndex(0);
		
		//Print the MRP
		String mrp = driver.findElement(By.xpath("(//div[@class='css-f5j3vf']//span)[2]")).getText();
		System.out.println(mrp);
		
		//Click on Add to Bag
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();
		
		//Grand Total 
		String total = driver.findElement(By.xpath("//div[@class='table-row ']/div[@class='value medium-strong']")).getText();
		System.out.println(total);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		

	}

}
