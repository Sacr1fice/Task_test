package test.site.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BrowserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By exactPageOpen = By.className("main-header");

    public void getStartedForAlert() {
        wait.until(ExpectedConditions.textToBe(exactPageOpen, "Alerts, Frame & Windows"));

    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul[@class='menu-list']//li[@id='item-0']")
    private WebElement browser;

    public void openBrowserPage() {
        browser.click();

    }

    public void openNewTab() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public void openNewWindow() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(3000);
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
