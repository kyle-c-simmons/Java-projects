import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='FormsButton2']")
    private WebElement login;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void loginUser() {
        login.click();
    }


}
