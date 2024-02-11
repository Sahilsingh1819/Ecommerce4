package pck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NewTest {

	public static void main(String[] args) {
		System.setProperty("WebDriver.Chrome.diver", "\"C:\\all drivers selenium\\chromedriver.exe\"");
		WebDriver driver = new ChromeDriver();
		//	WebDriver driver=Start.getChrome();
		Amazon amazon=new Amazon(driver);
		amazon.step5("7000276337", "Sahil123!@#");
		
		
		
	}

}