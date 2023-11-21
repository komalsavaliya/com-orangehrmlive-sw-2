package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “Admin” username
 * * Enter “admin123 password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Dashboard’ text is display
 */
public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter User Name to User Name field
         driver.findElement(By.name("username")).sendKeys("Admin");
        //driver.findElement(By.xpath("//input[@ name = 'username']")).sendKeys("Admin");


        //Enter the password  to password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@ name = 'password']")).sendKeys("admin123");


        //Click on login button
        ///WebElement login = driver.findElement(By.xpath("//button[@type ='submit']"));
        driver.findElement(By.xpath("//button[@class ='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();


        //verify the Dashboard text is Display
        String exceptedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//div[@class = 'oxd-topbar-header-title']//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

