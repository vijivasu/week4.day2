package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStation.sendKeys("MAS");
		Thread.sleep(3000);
		fromStation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		WebElement toStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStation.sendKeys("CBE");
		Thread.sleep(3000);
		toStation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(5000);
		
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]/a"));
		System.out.println(trainNames.size());
		
		List<String> trainNamesEle = new ArrayList<String>();
		for (WebElement eachelement : trainNames) {
			String text = eachelement.getText();
			boolean add = trainNamesEle.add(text);
			System.out.println(text);
			
		}
		Set<String> trains = new HashSet<String>(trainNamesEle);
		if(trainNamesEle.size() == trains.size()) {
			System.out.println("No Duplicates");
		}else {
			System.out.println("Duplicates Found");
		}
		
		
				

	}

}
