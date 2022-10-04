package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		List<WebElement> securityNames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr/td[3]"));
		
		System.out.println(securityNames.size());
		
		List<String> names = new ArrayList<String>();
	for (int i = 0; i < securityNames.size(); i++) {
		String text = securityNames.get(i).getText();
		names.add(text);
	}
	System.out.println(names);
	System.out.println("list size"+names.size());
		Set<String> identifyDup = new HashSet<String>(names);
		System.out.println("Set Size "+identifyDup.size());
		if(names.size()==(identifyDup.size())) {
			System.out.println("No Duplicates");
		}else {
			System.out.println("Duplicates Found");
		}
		
	}

}
