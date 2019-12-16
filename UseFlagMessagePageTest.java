package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UseFlagMessagePage;

import java.util.concurrent.TimeUnit;

public class UseFlagMessagePageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private UseFlagMessagePage useFlagMessagePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:/DZ/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPage = new LoginPage(driver);
        useFlagMessagePage = new UseFlagMessagePage(driver);
    }


    @Test
    public void flagVisibilityTest() throws InterruptedException {
        loginPage.enterLogin("prokopchik.vityusha@mail.ru");
        loginPage.clickEnterButton();
        loginPage.enterPass("Asusx54c");
        loginPage.clickEnterButton();
        Thread.sleep(15000);
        useFlagMessagePage.addFlag();
        Assert.assertTrue(useFlagMessagePage.isFlagFirstVisibility());
        Assert.assertTrue(useFlagMessagePage.isFlagSecondVisibility());
        Assert.assertTrue(useFlagMessagePage.isFlagThirdVisibility());
        useFlagMessagePage.addFlag();
    }
}
