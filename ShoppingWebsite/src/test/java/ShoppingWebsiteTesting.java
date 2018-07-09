import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class ShoppingWebsiteTesting {
    ChromeDriver driver;
    String url = "http://automationpractice.com/index.php";

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

        // Clicks the search bar
        WebElement clickSearch = driver.findElement(By.id("search_query_top"));
        clickSearch.click();
        clickSearch.sendKeys("dress");
        Thread.sleep(500);
        clickSearch.click();
        Thread.sleep(500);

        // Dress on page
        WebElement dress = driver.findElement(By.xpath("//img[@alt='']"));


        assertEquals("Printed Summer Dress", dress.getText());
    }




}
