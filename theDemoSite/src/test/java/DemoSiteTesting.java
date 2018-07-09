import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class DemoSiteTesting {

    ChromeDriver driver;
    String url = "https://thedemosite.co.uk/";

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

    @Test
    public void methodTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);

        // Create user
        WebElement clickAddUser = driver.findElement(By.partialLinkText("Add a User"));
        clickAddUser.click();
        Thread.sleep(1000);

        WebElement clickUserName = driver.findElement(By.name("username"));
        clickUserName.sendKeys("user");
        Thread.sleep(1000);

        WebElement clickPassword = driver.findElement(By.name("password"));
        clickPassword.sendKeys("password");
        Thread.sleep(1000);

        WebElement clickSubmit = driver.findElement(By.name("FormsButton2"));
        clickSubmit.click();
        Thread.sleep(1000);

        // Login
        WebElement clickLogin = driver.findElement(By.partialLinkText("Login"));
        clickLogin.click();
        Thread.sleep(1000);

        WebElement enterUser = driver.findElement(By.name("username"));
        enterUser.sendKeys("user");
        Thread.sleep(1000);

        WebElement enterPass = driver.findElement(By.name("password"));
        enterPass.sendKeys("password");
        Thread.sleep(1000);

        WebElement login = driver.findElement(By.name("FormsButton2"));
        login.click();
        Thread.sleep(1000);

        WebElement getSuccess = driver.findElement(By.xpath("//font/center"));

        assertEquals("**Successful Login**", getSuccess.getText());

    }



}
