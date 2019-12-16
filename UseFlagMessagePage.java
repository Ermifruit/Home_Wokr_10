package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseFlagMessagePage {
    private WebDriver driver;
    @FindBy(xpath = "(.//div[@class=\"llc__item llc__item_flag\"])[1]")
    private WebElement firstMessageFlag;
    @FindBy(xpath = "(.//div[@class=\"llc__item llc__item_flag\"])[2]")
    private WebElement secondMessageFlag;
    @FindBy(xpath = "(.//div[@class=\"llc__item llc__item_flag\"])[3]")
    private WebElement thirdMessageFlag;

    public UseFlagMessagePage(WebDriver webdriver) { PageFactory.initElements(webdriver, this);
    }


    public void addFlag(){
        firstMessageFlag.click();
        secondMessageFlag.click();
        thirdMessageFlag.click();
    }
    public boolean isFlagFirstVisibility(){
        return firstMessageFlag.isEnabled();
    }

    public boolean isFlagSecondVisibility(){
        return secondMessageFlag.isEnabled();
    }
    public boolean isFlagThirdVisibility(){
        return thirdMessageFlag.isEnabled();
    }
}