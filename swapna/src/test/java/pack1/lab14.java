package pack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class lab14 {

    @Test
    public void registerUserFromExcel() throws IOException, InterruptedException {

        // ✅ Step 1: Read data from Excel file
        FileInputStream fis = new FileInputStream("src/test/resources/UserDetails.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);

        String firstName = sheet.getRow(1).getCell(0).getStringCellValue();
        String lastName = sheet.getRow(1).getCell(1).getStringCellValue();
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        String telephone = sheet.getRow(1).getCell(3).getStringCellValue();
        String password = sheet.getRow(1).getCell(4).getStringCellValue();
        String confirmPassword = sheet.getRow(1).getCell(5).getStringCellValue();

        workbook.close();
        fis.close();

        // ✅ Step 2: Setup Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Step 3: Open the website
        driver.get("https://tutorialsninja.com/demo/");
        Assert.assertEquals(driver.getTitle(), "Your Store", "Title mismatch!");
        System.out.println("✅ Page title verified: " + driver.getTitle());

        // ✅ Step 4: Click on My Account → Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // ✅ Step 5: Verify page heading
        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(heading.isDisplayed(), "Register Account heading not found!");
        System.out.println("✅ Register Account page opened");

        // ✅ Step 6: Fill registration form
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

        // ✅ Step 7: Agree to Privacy Policy
        driver.findElement(By.name("agree")).click();

        // ✅ Step 8: Click Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // ✅ Step 9: Verify success message
        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Account creation message not displayed!");
        System.out.println("🎉 " + successMsg.getText());

        // ✅ Step 10: Close browser
        driver.quit();
    }
}
