import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSearchedPage {

    // Go to search bar and search
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]")
    private WebElement findDress;

    public void clickDress() {
        findDress.click();
    }

    public String getDress() {
        return findDress.getText();
    }

}
