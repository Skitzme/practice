package com.LoginTestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectPassword {
	
	
		@Test
		@Parameters({"username","password"})
		public void loginWithCorrectPassword(String uName, String pWord)
		{
			System.setProperty("driver.chrome.driver", "D:\\selenium practice\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();  //browsercompatablity
			option.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			WebElement userName= driver.findElement(By.cssSelector("input[name='username']")); ////input[@placeholder='Password']
			userName.sendKeys(uName);
			WebElement passWord= driver.findElement(By.cssSelector("input[name='password']"));
			passWord.sendKeys(pWord);  
			 WebElement loginButton= driver.findElement(By.tagName("button"));
			 loginButton.click();
			 driver.quit();
		}
		

}
