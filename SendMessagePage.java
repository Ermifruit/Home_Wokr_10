package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessagePage {
    @FindBy(xpath = ".//span[@title=\"Написать письмо\"]")
    private WebElement buttonNewMessage;
    @FindBy(xpath = "//label[@class='container--zU301']")
    private WebElement whom;
    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subject;
    @FindBy(xpath = ".//span[text()='Отправить']")
    private WebElement sendButton;
    @FindBy(xpath = ".//span[text()='отправлено']")
    private WebElement sendMessage;
    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement addText;

    public SendMessagePage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
    }

    public void createNewMessage() {
        buttonNewMessage.click();
    }

    public void setDestination() {
        whom.sendKeys("prokopchik.vityusha@mail.ru, prokopchik.elena1987@mail.ru, prokopchik.nika@mail.ru");
        subject.sendKeys("I will never forget the mistakes of my youth ....");
        addText.sendKeys("I'm very tired now....bye bye....i'm going to sleep");
    }

    public void sendMessage() {
        sendButton.click();
    }

    public boolean sendMessageLink() {
        return sendMessage.isDisplayed();
    }
}
