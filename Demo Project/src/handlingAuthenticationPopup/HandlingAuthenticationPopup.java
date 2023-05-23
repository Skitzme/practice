package handlingAuthenticationPopup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationPopup {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//url: http://username:password@the-internet.herokuapp.com/basic_auth

	}

}
