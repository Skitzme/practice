package com.openHrm.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "D:\\selenium practice\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();  //browsercompatablity
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName= driver.findElement(By.cssSelector("input[name='username']")); 
		userName.sendKeys("Admin");
		WebElement passWord= driver.findElement(By.cssSelector("input[name='password']"));
		passWord.sendKeys("admin123");  
		WebElement loginButton= driver.findElement(By.tagName("button"));
		loginButton.click();
		WebElement dropDown1= driver.findElement(By.className("oxd-userdropdown-tab")); 
		dropDown1.click();
		Thread.sleep(1000);
		WebElement logOutLink= driver.findElement(By.linkText("Logout"));
		Thread.sleep(1000);
		logOutLink.click();


	}

}
