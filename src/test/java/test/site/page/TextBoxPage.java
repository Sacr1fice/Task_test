package test.site.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.site.data.DataHelper;

import java.time.Duration;


public class TextBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul[@class='menu-list']//li[@id='item-0']")
    private WebElement txtButton;

    public void openTextBoxPage() {
        txtButton.click();

    }

    public void fillFullName() {
        driver.findElement(By.id("userName")).sendKeys(DataHelper.generateRandomName());

    }

    public void fillEmail() {
        driver.findElement(By.id("userEmail")).sendKeys(DataHelper.generateRandomEmail());
    }

    public void fillCurrentAddress() {
        driver.findElement(By.id("currentAddress")).sendKeys(DataHelper.generateRandomAddress());
    }

    public void fillPermanentAddress() {
        driver.findElement(By.id("permanentAddress")).sendKeys(DataHelper.generateRandomAddress());
    }


    public void submitForm() {
        driver.findElement(By.id("submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
    }
}
