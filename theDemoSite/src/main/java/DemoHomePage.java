import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage {

    // Go to the add user page
    @FindBy(xpath = "//a[contains(@href, 'addauser.php')]")
    private WebElement clickAdduser = null;

    public void clickAddUserPage() {
        clickAdduser.click();
    }


}
