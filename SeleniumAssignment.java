package seleniumAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment {
	public static void main(String[] args) throws InterruptedException {
		
		// Creating instance of ChromeDriver Class
		ChromeDriver driver = new ChromeDriver();
		
		// Launching Chrome Browser
		driver.get("http://www.google.com/");
		Thread.sleep(2000); // Waiting for the window to appear
		
		// Maximizing the Window
		driver.manage().window().maximize();
		
		
		// Locating the Search Bar
		WebElement searchBar = driver.findElement(By.id("APjFqb"));
		
		searchBar.sendKeys("selenium tutorial");		// Passing the query in the search bar
		searchBar.sendKeys(Keys.ENTER); // Pressing the Enter Key
		Thread.sleep(2000); // Waiting for the results to come
		
		List<WebElement> divList = driver.findElements(By.xpath("//*[@id=\"search\"]//div[@class='yuRUbf']")); // Fetching the list of the results appeared
		System.out.println("Size of the List: " + divList.size());  // Displaying the size of the list of results
		
		// Printing the Suggestions/Results one by one
		for(int i = 0; i < divList.size(); i++) {
			WebElement e = divList.get(i).findElement(By.tagName("h3"));
			System.out.println(e.getText());
		}
			
	
		// clicking on a suggestion
		divList.get(12).findElement(By.tagName("a")).click();
		Thread.sleep(2000); // Waiting for the site to open
		
		String title = driver.getTitle(); // Fetching the title of the website
		System.out.println("Ttile of the page: " + title);  // Displaying the title
		Thread.sleep(2000);
		
		driver.close();  // Closing the browser
		
		
	}
}
