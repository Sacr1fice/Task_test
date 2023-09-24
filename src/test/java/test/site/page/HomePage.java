package test.site.page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsButton;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsButton;

    public void openElementsPage() {
        elementsButton.click();

    }

    public void openBrowserPage() {
        alertsButton.click();

    }

}