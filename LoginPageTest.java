package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;


public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:/DZ/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.enterLogin("prokopchik.vityusha@mail.ru");
        loginPage.clickEnterButton();
        loginPage.enterPass("Asusx54c");
        loginPage.clickEnterButton();
        Thread.sleep(10000);
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @Test
    public void movingSpam() {
        loginPage.goToInboxFolder();
        loginPage.selectFirstLetter();
        loginPage.moveInSpam();
        Assert.assertTrue(loginPage.intoSpamMessage());
    }

    @Test
    public void movingFromSpam() throws InterruptedException {
        loginPage.goToSpam();
        Thread.sleep(2000);
        loginPage.selectFirstLetter();
        Thread.sleep(2000);
        loginPage.extractFromSpam();
        Assert.assertTrue(loginPage.outOfSpamMessage());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
