import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingHomePage {

    // Go to search bar and search
    @FindBy(id = "search_query_top")
    private WebElement clickSearch = null;

    public void clickSearchBar() {
        clickSearch.click();
    }

    public void setSearchBar(String item) {
        clickSearch.sendKeys(item);
        clickSearch.click();
    }

}
