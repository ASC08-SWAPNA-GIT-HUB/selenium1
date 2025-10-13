package swapna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		if(title.equals("Your Store"))
		{
			System.out.println("Title is matched");
		}
		else
		{
			System.out.println("Title is not matched");
		}
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
		String warning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println("Warning message is:"+warning);
		if(warning.equals("You must agree to the Privacy Policy!"))
		{
			System.out.println("warning is matched");
		}
		else
		{
			System.out.println("warning is not matched");
		}
		WebElement subs=driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
		if(subs.isSelected())
		{
			System.out.println("yes is selected");
		}
		else
		{
			System.out.println("yes is not selected");
		}
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("GEDELA"); 
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.getPageSource().contains("First Name must be between 1 and 32 characters!")) {
            System.out.println("Validation displayed for First Name length.");
            firstName = driver.findElement(By.id("input-firstname")); 
            firstName.clear();
            firstName.sendKeys("SWAPNA");
        }
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); 
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.getPageSource().contains("Last Name must be between 1 and 32 characters!")) {
            System.out.println("Validation displayed for Last Name length.");
            lastName = driver.findElement(By.id("input-lastname"));
            lastName.clear();
            lastName.sendKeys("G");
        }
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("SWAPNA" + System.currentTimeMillis() + "@gmail.com");
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("123456789");
        WebElement password = driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("class@123");
        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.clear();
        confirmPassword.sendKeys("class@123");
        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
        if (!newsletterYes.isSelected()) {
        	newsletterYes.click();
            System.out.println("Newsletter 'Yes' selected");
        } else {
        	System.out.println("Newsletter 'Yes' already selected");
        }
        WebElement privacyPolicy = driver.findElement(By.name("agree"));
        if (!privacyPolicy.isSelected()) {
        	privacyPolicy.click();
        }
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.getPageSource().contains("Your Account Has Been Created!")) {
        	System.out.println("🎉 Registration successful!");
        } else if (driver.getPageSource().contains("Warning")) {
        	System.out.println("⚠️ Registration failed – check validation warnings.");
        }
        else {
        	System.out.println("⚠️ Registration might have failed – verify inputs.");
        }
        WebElement continueBtn = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueBtn.click();
        System.out.println("Clicked on 'Continue'");
        WebElement orderHistoryLink = driver.findElement(By.linkText("View your order history"));
        orderHistoryLink.click();
        System.out.println("Clicked on 'View your order history' link");
        if (driver.getPageSource().contains("Order History")) {
        	System.out.println("Order History page displayed successfully!");
        } else {
        	System.out.println("Failed to open Order History page!");
        }
	}
}
    
    
    
    
  