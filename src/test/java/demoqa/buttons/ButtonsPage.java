package demoqa.buttons;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage {

    private SelenideElement doubleClickBtn = $("#doubleClickBtn");
    private SelenideElement rightClickBtn = $("#rightClickBtn");
    private SelenideElement dynamicClickBtn = $x("//button[text()='Click Me']");
    private SelenideElement doubleClickMessage = $("#doubleClickMessage");
    private SelenideElement rightClickMessage = $("#rightClickMessage");
    private SelenideElement dynamicClickMessage = $("#dynamicClickMessage");

    public ButtonsPage() {
        Selenide.open("buttons");
    }

    public SelenideElement getDoubleClickMessage() {
        return doubleClickMessage;
    }

    public SelenideElement getRightClickMessage() {
        return rightClickMessage;
    }

    public SelenideElement getDynamicClickMessage() {
        return dynamicClickMessage;
    }

    public void clickDoubleClickBtn() {
        doubleClickBtn.doubleClick();
    }

    public void clickRightClickButton() {
        rightClickBtn.contextClick();
    }

    public void clickDynamicClickButton() {
        dynamicClickBtn.click();
    }
}
