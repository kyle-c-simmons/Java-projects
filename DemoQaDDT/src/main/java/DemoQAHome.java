import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHome {

    @FindBy(xpath = "//li[@id='menu-item-141']/a")
    private WebElement droppable;

    public void clickDroppable() {
        droppable.click();
    }

}
