package demoqa.buttons;

import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class ButtonsTest extends BaseSelenideTest {

    private final ButtonsPage page = new ButtonsPage();

    @Test
    @DisplayName("Should show message when double clicking first button")
    public void doubleClickFirstButton() {
        page.clickDoubleClickBtn();

        String expectedMessage = "You have done a double click";

        page.getDoubleClickMessage().shouldBe(text(expectedMessage));
        page.getRightClickMessage().shouldNot(exist);
        page.getDynamicClickMessage().shouldNot(exist);
    }
    @Test
    @DisplayName("Should show message when right clicking second button")
    public void rightClickSecondButton() {
        page.clickRightClickButton();

        String expectedMessage = "You have done a right click";

        page.getRightClickMessage().shouldBe(text(expectedMessage));
        page.getDynamicClickMessage().shouldNot(exist);
        page.getDoubleClickMessage().shouldNot(exist);
    }

    @Test
    @DisplayName("Should show message when clicking third button")
    public void clickThirdButton() {
        page.clickDynamicClickButton();

        String expectedMessage = "You have done a dynamic click";

        page.getDynamicClickMessage().shouldBe(text(expectedMessage));
        page.getDoubleClickMessage().shouldNot(exist);
        page.getRightClickMessage().shouldNot(exist);
    }
}
