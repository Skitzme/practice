package takeScreenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotExample {

	public static void main(String[] args) throws IOException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/waits/#explicit-wait");
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourceFile=	screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("D://sample.png");
		FileHandler.copy(sourceFile, destinationFile) ;

		// take screeshot selected area
		WebElement selectedArea=driver.findElement(By.xpath("(//pre[contains(@class,'language-java')])[11]"));
		File sourceFile1= selectedArea.getScreenshotAs(OutputType.FILE);
		File destinationFile1=new File("D://selectedarea.png");
		FileHandler.copy(sourceFile1, destinationFile1);
		//take screenshot specific element
		WebElement logoElement=driver.findElement(By.xpath("//*[@id='Layer_1']"));
		File sourceFile2=	logoElement.getScreenshotAs(OutputType.FILE);
		File destinationFile2=new File("D://logoElement.png");
		FileHandler.copy(sourceFile2, destinationFile2);

		//take scrrenshot fullscreen
		Robot robot=new Robot();
		Dimension screenSize=	Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(screenSize);
		BufferedImage source= robot.createScreenCapture(rectangle);
		
		File destination=new File("D://robotsnap.png");
		ImageIO.write(source, "png", destination);
		driver.quit();
	}
}
