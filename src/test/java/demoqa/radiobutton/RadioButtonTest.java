package demoqa.radiobutton;

import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class RadioButtonTest extends BaseSelenideTest {

    private final RadioButtonPage page = new RadioButtonPage();

    @Test
    @DisplayName("Should show that selected option was 'yes'")
    public void selectYes() {
        String expectedOutput = "Yes";

        page.clickYesRadio();
        page.getSelectedRadioText().shouldHave(text(expectedOutput));
    }

    @Test
    @DisplayName("Should show that selected option was 'impressive'")
    public void selectImpressive() {
        String expectedOutput = "Impressive";

        page.clickImpressiveRadio();
        page.getSelectedRadioText().shouldHave(text(expectedOutput));
    }

    @DisplayName("'No' button should be unclickable and there should be no output text")
    @Test()
    public void selectNo() {
        page.clickNoRadio();
        page.getSelectedRadioText().shouldNot(exist);
        page.getNoInput().shouldBe(disabled);
        page.getNoInput().shouldHave(cssClass("disabled"));
        page.getNoRadio().shouldHave(cssClass("disabled"));
    }
}
