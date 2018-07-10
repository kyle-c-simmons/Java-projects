import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class SearchDressTesting {

    WebDriver driver;

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
    public void searchTesting() {
        driver.manage().window().maximize();

        // Home
        driver.get("http://automationpractice.com/index.php");
        ShoppingHomePage homePage = PageFactory.initElements(driver, ShoppingHomePage.class);
        homePage.clickSearchBar();
        homePage.setSearchBar("dress");

        // SearchedPage
        ShoppingSearchedPage searched = PageFactory.initElements(driver, ShoppingSearchedPage.class);
        searched.clickDress();
        System.out.println(searched.getDress());
       // assertEquals("Printed Summer Dress", searched.getDress());

    }

}
