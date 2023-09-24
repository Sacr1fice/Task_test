package test.site.page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ElementsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    private By pageOpen = By.className("main-header");

    public void getStarted() {
        wait.until(ExpectedConditions.textToBe(pageOpen, "Elements"));
    }
}
