import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;


public class DemoQATesting {

    private WebDriver driver;
    Constants constants = new Constants();

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

    // Test if droppable works
    @Test
    public void droppableTest() throws InterruptedException {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);

        // Go to droppable page
        driver.get(constants.URL1);
        qaHome.clickDroppable();

        DemoQADroppable qaDroppable = PageFactory.initElements(driver, DemoQADroppable.class);


        // Get the drag me element
        Actions action = new Actions(driver);
        action.moveByOffset(639,390).dragAndDrop(qaDroppable.draggable, qaDroppable.droppable);

        try {
            assertEquals(qaDroppable.droppable, qaDroppable.draggable);


        } catch (Exception e) {

        } finally {

        }
    }




}
