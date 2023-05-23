package maximizwWays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximizeWays {

	public static void main(String[] args) {
		
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		
		WebDriver driver=new ChromeDriver(chromeoptions);
		//driver.manage().window().maximize();
		
		//Dimension dimension=new Dimension(1920, 1080);
		//driver.manage().window().setSize(dimension); //void org.openqa.selenium.WebDriver.Window.setSize(Dimension targetSize)
		
		driver.get("https://www.google.co.in/"); 
		WebElement gTextArea=driver.findElement(By.name("q"));
		gTextArea.sendKeys("msDhoni"+Keys.ENTER);
	}

}
