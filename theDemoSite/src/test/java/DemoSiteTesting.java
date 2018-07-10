import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class DemoSiteTesting {

    ChromeDriver driver;
    ExtentReports report = new ExtentReports("C:/Users/Admin/Desktop/Basicreport.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    /*
    1) Go to home page
    2) Create a user
    3) Login
     */
    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();

        test = report.startTest("Verify user can create account");
        test.log(LogStatus.INFO, "Browser started");

        // Home page
        driver.get("https://thedemosite.co.uk/");
        DemoHomePage homePage = PageFactory.initElements(driver, DemoHomePage.class);
        homePage.clickAddUserPage();
        test.log(LogStatus.PASS, "verify that the user can create an account");


        // Add user page
        driver.get("https://thedemosite.co.uk/addauser.php");
        DemoAdduserPage adduserPage = PageFactory.initElements(driver, DemoAdduserPage.class);

        adduserPage.setEnterUsername("Username");
        adduserPage.setEnterPasswordl("Password");
        adduserPage.clickSubmitAdduser();

        // Login
        driver.get("https://thedemosite.co.uk/login.php");
        DemoLoginPage loginPage = PageFactory.initElements(driver, DemoLoginPage.class);

        loginPage.enterUsername("Username");
        loginPage.enterPassword("Password");
        loginPage.loginUser();

        report.endTest(test);
        report.flush();

    }



}
