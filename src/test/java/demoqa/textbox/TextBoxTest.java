package demoqa.textbox;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class TextBoxTest extends BaseSelenideTest {

    private final TextBoxPage page = new TextBoxPage();

    @Test
    @DisplayName("Should display user input in text box")
    public void SubmitCorrectData() {
        String name = "Max";
        String email = "correct.email@gmail.com";
        String currentAddress = "garanina 32";
        String permanentAddress = "pushkina 3";

        List<String> input = List.of(name, email, currentAddress, permanentAddress);

        page.fillNameForm(name);
        page.fillEmailForm(email);
        page.fillCurrentAddressForm(currentAddress);
        page.fillPermanentAddressForm(permanentAddress);
        page.submitData();

        ElementsCollection output = page.getDataOutput();

        for (int i = 0; i < output.size(); i++) {
            String expectedValue = input.get(i);
            SelenideElement actualValue = output.get(i);
            actualValue.shouldHave(text(expectedValue));
        }
    }

    @Test
    @DisplayName("Doesn't show user input if no data is submitted")
    public void SubmitEmptyData() {
        String emptyInput = "";

        page.fillNameForm(emptyInput);
        page.fillEmailForm(emptyInput);
        page.fillCurrentAddressForm(emptyInput);
        page.fillPermanentAddressForm(emptyInput);
        page.submitData();

        ElementsCollection output = page.getDataOutput();

        Assertions.assertTrue(output.isEmpty());
    }

    @Test
    @DisplayName("Should highlight email textbox red if invalid email is submitted")
    public void SubmitInvalidEmail() {
        String invalidEmail = "invalid";
        String errorClass = "field-error";

        page.fillEmailForm(invalidEmail);
        page.submitData();

        page.getEmailForm().shouldHave(cssClass(errorClass));
    }
}
