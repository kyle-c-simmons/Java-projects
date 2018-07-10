import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAdduserPage {

    @FindBy(name = "username")
    private WebElement setUsername;

    @FindBy(name = "password")
    private WebElement setPassword;

    @FindBy(name = "FormsButton2")
    private WebElement submitAdduser;

    public void setEnterUsername(String username) {
        setUsername.sendKeys(username);
    }

    public void setEnterPasswordl(String password) {
        setPassword.sendKeys(password);
    }

    public void clickSubmitAdduser() {
        submitAdduser.click();
    }

}
