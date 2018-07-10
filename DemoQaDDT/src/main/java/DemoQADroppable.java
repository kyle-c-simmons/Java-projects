import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADroppable {

    @FindBy(id = "draggableview")
    public WebElement draggable;

    @FindBy(id = "droppableview")
    public WebElement droppable;


}
