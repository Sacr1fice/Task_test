package test.site.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul[@class='menu-list']//li[@id='item-4']")
    private WebElement buttons;

    public void openButtonPage() {
        buttons.click();

    }

    public void ShouldClicked() {

        WebElement ClickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        new Actions(driver)
                .click(ClickBtn)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));

    }

    public void ShouldDoubleClicked() {

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver)
                .doubleClick(doubleClickBtn)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

    }

    public void ShouldRightClicked() {

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        new Actions(driver)
                .contextClick(rightClickBtn)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));

    }

}