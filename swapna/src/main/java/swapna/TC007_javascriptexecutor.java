package swapna;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_javascriptexecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://amazon.in");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('welcome to javascriptexe');");
		js.executeScript("window.scrollBy(0,700)");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");


	}

}
