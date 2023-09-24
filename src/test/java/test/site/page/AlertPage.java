package test.site.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul[@class='menu-list']//li[@id='item-1']")
    private WebElement alert;

    public void openBrowserPage() {
        alert.click();

    }

    public void clickOnAlertBtn() {
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnAlertBtnWithTimer() {
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    private By confirmResult = By.id("confirmResult");

    public void clickOnAlertBtnWithConfirmBox() {
        driver.findElement(By.id("confirmButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.textToBe(confirmResult, "You selected Ok"));
    }

    private By promptResult = By.id("promptResult");

    public void clickOnAlertBtnWithPrompt() {
        driver.findElement(By.id("promtButton")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("TestName");
        alert.accept();
        wait.until(ExpectedConditions.textToBe(promptResult, "You entered TestName"));
    }
}
