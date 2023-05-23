package printheGoogleSuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintMainUrl {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		WebElement textBox= driver.findElement(By.name("q"));
		textBox.sendKeys("automation test engineer"+Keys.ENTER);
		List<WebElement> totalLinks=driver.findElements(By.tagName("a"));
		for (WebElement link : totalLinks) {
			System.out.println(link.getAttribute("href")); 
		}
		System.out.println("--------------------------------------------------------------");
		Thread.sleep(2000);
		List<WebElement> fetchMainLink=driver.findElements(By.xpath("(//div[@id='search']//following::h3//following::div)[4]//following::cite"));
		for (WebElement mainlink : fetchMainLink) {
			System.out.println(mainlink.getText());
		}
	}
}
