package demoqa.textbox;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement fullNameForm = $("#userName");
    private final SelenideElement emailForm = $("#userEmail");
    private final SelenideElement currentAddressForm = $("#currentAddress");
    private final SelenideElement permanentAddressForm = $("#permanentAddress");

    private final SelenideElement submitButton = $x("//button[@id='submit']/..");


    public SelenideElement getEmailForm() {
        return emailForm;
    }

    public TextBoxPage() {
        Selenide.open("text-box");
    }

    public void fillNameForm(String name) {
        fullNameForm.click();
        fullNameForm.sendKeys(name);
    }

    public void fillEmailForm(String email) {
        emailForm.click();
        emailForm.sendKeys(email);
    }

    public void fillCurrentAddressForm(String currentAddress) {
        currentAddressForm.click();
        currentAddressForm.sendKeys(currentAddress);
    }

    public void fillPermanentAddressForm(String permanentAddress) {
        permanentAddressForm.click();
        permanentAddressForm.sendKeys(permanentAddress);
    }

    public void submitData() {
        submitButton.click();
    }

    public ElementsCollection getDataOutput() {
        ElementsCollection outputElements = $$x("//div[@id='output']//div/*");
        return outputElements;
    }
}