package demoqa.radiobutton;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonPage {

    private final SelenideElement yesRadio = $x("//label[@for='yesRadio']");
    private final SelenideElement impressiveRadio = $x("//label[@for='impressiveRadio']");
    private final SelenideElement noRadio = $x("//label[@for='noRadio']");
    private final SelenideElement noInput = $x("//input[@id='noRadio']");
    private final SelenideElement selectedRadioText = $x("//p[@class='mt-3']//span[@class='text-success']");

    public RadioButtonPage() {
        Selenide.open("radio-button");
    }

    public SelenideElement getSelectedRadioText() {
        return selectedRadioText;
    }

    public SelenideElement getNoRadio() {
        return noRadio;
    }

    public SelenideElement getNoInput() {
        return noInput;
    }

    public void clickYesRadio() {
        yesRadio.click();
    }

    public void clickImpressiveRadio() {
        impressiveRadio.click();
    }

    public void clickNoRadio() {
        noRadio.click();
    }
}
