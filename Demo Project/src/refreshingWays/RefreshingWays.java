package refreshingWays;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RefreshingWays {

	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/"); 
		WebElement gTextArea=driver.findElement(By.name("q"));
		gTextArea.sendKeys("msDhoni"+Keys.ENTER);
		//driver.navigate().refresh(); //way1
		//driver.get(driver.getCurrentUrl());//way 2

		//javascriptexcutor
		//		JavascriptExecutor executor=(JavascriptExecutor) driver;
		//		executor.executeScript("location.reload()"); //"history.go(0)"

		/*
		 * Robot robot=new Robot(); robot.keyPress(KeyEvent.VK_F5);
		 * robot.keyRelease(KeyEvent.VK_F5);
		 */

		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		action.keyUp(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
	}
}
