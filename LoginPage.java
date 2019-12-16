package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@value='Ввести пароль']")
    private WebElement submit;

    @FindBy(xpath = ".//input[@value=\"Ввести пароль\"]")
    private WebElement buttonEnter;

    @FindBy(xpath = ".//a[text()='выход']")
    private WebElement logoutLink;

    @FindBy(xpath = "(.//div[@class=\"llc__avatar\"])[1]")
    private WebElement selectLetter;
    @FindBy(xpath = ".//span[text()='Спам']")
    private WebElement buttonSpamMessage;
    @FindBy(xpath = ".//span[text()='Перемещено в спам']")
    private WebElement spamMessage;

    @FindBy(xpath = "//a[@href='/spam/']")
    private WebElement buttonSpam;

    @FindBy(xpath = "//a[@href=\"/inbox/\"]")
    private WebElement inboxFolder;

    @FindBy(xpath = "(.//span[text()='Не спам'])[1]")
    private WebElement noSpamButton;

    @FindBy(xpath = ".//span[contains (text(),'Перемещено в папку ')]")
    private WebElement noSpamMessage;

    public LoginPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPass(String password) {
        emailField.sendKeys(password);
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public void selectFirstLetter(){
        selectLetter.click();
    }

    public void moveInSpam(){
        buttonSpamMessage.click();
    }

    public boolean intoSpamMessage(){
        return spamMessage.isDisplayed();
    }

    public boolean logoutLinkPresents() {
        return logoutLink.isDisplayed();
    }

    public void goToSpam(){
        buttonSpam.click();
    }
    public void extractFromSpam(){
        noSpamButton.click();

    }
    public boolean outOfSpamMessage(){
        return noSpamMessage.isDisplayed();
    }

    public void goToInboxFolder(){
        inboxFolder.click();
    }
}
