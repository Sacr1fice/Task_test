package test.site.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import test.site.page.*;




public class TestTaskTest {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

    }

    @AfterEach
    void teardown() {

        driver.quit();
    }

    @Test
    void shouldTestFormSubmitted() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openElementsPage();

        ElementsPage elementsPage = PageFactory.initElements(driver, ElementsPage.class);
        elementsPage.getStarted();

        TextBoxPage textBoxPage = PageFactory.initElements(driver, TextBoxPage.class);
        textBoxPage.openTextBoxPage();

        textBoxPage.fillFullName();
        textBoxPage.fillEmail();
        textBoxPage.fillCurrentAddress();
        textBoxPage.fillPermanentAddress();
        textBoxPage.submitForm();

        String expected = driver.findElement(By.id("userName")).getAttribute("value");
        String actual = driver.findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText();
        Assertions.assertTrue(actual.contains(expected));

        String expected2 = driver.findElement(By.id("userEmail")).getAttribute("value");
        String actual2 = driver.findElement(By.xpath("//div[@id='output']//p[@id='email']")).getText();
        Assertions.assertTrue(actual2.contains(expected2));

        String expected3 = driver.findElement(By.id("currentAddress")).getAttribute("value");
        String actual3 = driver.findElement(By.xpath("//div[@id='output']//p[@id='currentAddress']")).getText();
        Assertions.assertTrue(actual3.contains(expected3));

        String expected4 = driver.findElement(By.id("permanentAddress")).getAttribute("value");
        String actual4 = driver.findElement(By.xpath("//div[@id='output']//p[@id='permanentAddress']")).getText();
        Assertions.assertTrue(actual4.contains(expected4));
        Thread.sleep(3000);


    }

    @Test
    void shouldButtonsWorks() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openElementsPage();

        ElementsPage elementsPage = PageFactory.initElements(driver, ElementsPage.class);
        elementsPage.getStarted();

        ButtonsPage buttonsPage = PageFactory.initElements(driver, ButtonsPage.class);
        buttonsPage.openButtonPage();
        buttonsPage.ShouldClicked();
        buttonsPage.ShouldDoubleClicked();
        buttonsPage.ShouldRightClicked();


        Thread.sleep(3000);
    }

    @Test
    void shouldWindowOpenAndCloses() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openBrowserPage();

        BrowserPage browserPage = PageFactory.initElements(driver, BrowserPage.class);
        browserPage.getStartedForAlert();
        browserPage.openBrowserPage();
        browserPage.openNewTab();
        browserPage.openNewWindow();

        Thread.sleep(3000);
    }

    @Test
    void shouldAlertsWork() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openBrowserPage();

        BrowserPage browserPage = PageFactory.initElements(driver, BrowserPage.class);
        browserPage.getStartedForAlert();

        AlertPage alertPage = PageFactory.initElements(driver, AlertPage.class);
        alertPage.openBrowserPage();
        alertPage.clickOnAlertBtn();
        alertPage.clickOnAlertBtnWithTimer();
        alertPage.clickOnAlertBtnWithConfirmBox();
        alertPage.clickOnAlertBtnWithPrompt();


        Thread.sleep(3000);
    }
}