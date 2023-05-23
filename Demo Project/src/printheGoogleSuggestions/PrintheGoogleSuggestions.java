package printheGoogleSuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintheGoogleSuggestions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		WebElement textBox= driver.findElement(By.name("q"));
		textBox.sendKeys("automation test engineer");
		Thread.sleep(5000);
		List<WebElement> suggestionList=	driver.findElements(By.xpath("//ul[@role='listbox']//child::li"));
		String suggestedText;
		//int position=0;
		for (WebElement webElement : suggestionList) {
			suggestedText= webElement.getText();
			System.out.println(suggestedText);
			/*
			 * position++; //click the webelement with the help of positon if(position==3) {
			 * webElement.click(); break; }
			 */
			if(suggestedText.contains("chennai")) {
				webElement.click();
				break;
			}
		}
	}
}
