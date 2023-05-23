package com.apachePoi.loginTestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogintestCaseThroughApachePoi {

	List<String> userNames=new ArrayList<String>();
	List<String> passWords=new ArrayList<String>();

	public void readExcel() throws IOException
	{
		FileInputStream data=new FileInputStream("D:\\TestData\\Book2.xls");
		
		//org.apache.poi.ss.usermodel.Workbook
		Workbook workbook=new HSSFWorkbook(data); //horrible spreadsheet format
		Sheet sheet=	workbook.getSheetAt(0);
		
		Iterator<Row> rowiterator=	sheet.iterator();
		int i=0;

		while(rowiterator.hasNext())
		{
			Row rowValue=	rowiterator.next(); //it will return Row
			Iterator<Cell> columnIterator=rowValue.iterator(); //it will return iterator<cell>
			while(columnIterator.hasNext()) 
			{
				if(i%2==0)
				{
					userNames.add(columnIterator.next().getStringCellValue());
				}
				else
				{
					passWords.add(columnIterator.next().getStringCellValue());
				}
				i++;

			}
		}
		System.out.println("username list: " +userNames);
		System.out.println("password list: " +passWords);
	}
	
	public void login(String uName,String Password)
	{
		System.setProperty("driver.chrome.driver", "D:\\selenium practice\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();  //browsercompatablity
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName= driver.findElement(By.cssSelector("input[name='username']")); 
		userName.sendKeys(uName);
		WebElement passWord= driver.findElement(By.cssSelector("input[name='password']"));
		passWord.sendKeys(Password);  
		WebElement loginButton= driver.findElement(By.tagName("button"));
		loginButton.click();
		driver.quit();
		
	}
	
	public void excuteTest() {
		for(int i=0;i<userNames.size();i++) 
		{
			login(userNames.get(i),passWords.get(i));
		}
	}

	public static void main(String[] args) throws IOException {
		LogintestCaseThroughApachePoi object=new LogintestCaseThroughApachePoi();
		object.readExcel();
		object.excuteTest();
	}

}
