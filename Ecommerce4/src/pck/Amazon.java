package pck;


import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
;
public class Amazon {
	public static WebDriver driver;
	
	public Amazon(WebDriver drv) {
		this.driver=drv;
	}
	public static void step5(String MobileNumber,String Password )   {
	

//			
//	      WebDriver driver = new ChromeDriver();
//		WebDriver driver=Start.getChrome();
	        // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // Open Amazon website
	        driver.get("https://www.amazon.in/");
	        // Maximize the window
	        driver.manage().window().maximize();

	      //  Click login button
	        driver.findElement(By.id("nav-link-accountList")).click();
	        
	        
	        // Fill email 
//	        String MobileNumber = "";
	        driver.findElement(By.id("ap_email")).sendKeys(MobileNumber);
	        driver.findElement(By.id("continue")).click();

	        // Fill Password
//	        String Password = "";
	        driver.findElement(By.name("password")).sendKeys(Password);

	       
	        // Click sign-in button 
	        driver.findElement(By.id("signInSubmit")).click();

	        //Print Mobilenumber and password
	        System.out.println("Mobile number is" + MobileNumber );
	        System.out.println("Password is" + Password);
	        
	        
	        
	        // Search for a product
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple 15");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        
	      //Store the ID of the original window
	        String originalWindow = driver.getWindowHandle();

	        //Check we don't have other windows open already
	        assert driver.getWindowHandles().size() == 1;

	        // Click on the first search result
	        WebElement firstSearchResult = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	        firstSearchResult.click();

	      //Wait for the new window or tab
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	        
	      //Loop through until we find a new window handle
	        for (String windowHandle : driver.getWindowHandles()) {
	            if(!originalWindow.contentEquals(windowHandle)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        //Wait for the new tab to finish loading content
	        wait.until(titleIs("Apple iPhone 15 (256 GB) - Pink : Amazon.in: Electronics"));
	        
	     // Wait for the modal to appear after clicking "Add to Cart" button
	        WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement modalElement = modalWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")));

	        // Now interact with elements inside the modal
	        WebElement proceedToCheckoutButton = modalElement.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"));
	        proceedToCheckoutButton.click();
	        
	             
	        
	        //For close the add to cart screen 
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

	        driver.findElement(By.id("attach-close_sideSheet-link")).click();
	        
	        
	        //Click crose button
	        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            // click logo 
	        driver.findElement(By.id("nav-logo-sprites")).click();
	       
	        //Click on cart icon  
	        driver.findElement(By.id("nav-cart")).click();
	        
	        
	      
	        // Verify cart on home page
	        verifyCartOnHomePage(driver, "Apple iPhone 15 (256 GB) - Pink");
	    }

	    public static void verifyCartOnHomePage(WebDriver driver, String productName) {
	        // Verify if the added product is displayed in the cart
	        WebElement productInCart = driver.findElement(By.xpath("//span[@class='a-truncate-cut'][normalize-space()='" + productName + "']"));

	      //  if (productInCart.isDisplayed()) {
	     // Assert that the product in the cart matches the expected product name
	        if (productInCart.isDisplayed() && productInCart.getText().equals(productName)) {
	            System.out.println(productName + " is displayed in the cart.");
	        } else {
	            System.out.println(productName + " is not displayed in the cart.");
	        }
	        

	}
	
	public static ExpectedCondition<Boolean> numberOfWindowsToBe(final int number) {
	    return new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            return driver.getWindowHandles().size() == number;
	        }

	        @Override
	        public String toString() {
	            return String.format("number of windows to be %d", number);
	        }
	    };
	}

	public static ExpectedCondition<Boolean> titleIs(final String title) {
	    return new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	        	System.out.println("Driver" + driver.getTitle());
	        	System.out.println("title" +  title);
	            return driver.getTitle().equals(title);
	        }

	        @Override
	        public String toString() {
	            return String.format("Windows to be %s", title);
	        }
	    };
	}

}




