package demoqa.practiceform;

import com.codeborne.selenide.WebElementCondition;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class PracticeFormTest extends BaseSelenideTest {

    private final PracticeFormPage page = new PracticeFormPage();

    @Test
    @DisplayName("Should submit only required fields and show their value in a modal dialog")
    public void submitOnlyRequiredFields() {
        String firstName = "Stephen";
        String lastName = "Jablonsky";
        StudentGender gender = StudentGender.Male;
        String mobileNumber = "0123456789";

        page.fillFirstNameForm(firstName);
        page.fillLastNameForm(lastName);
        page.clickGenderRadio(gender);
        page.fillPhoneNumberForm(mobileNumber);
        page.clickSubmitButton();

        page.getStudentNameTableRow()
                .shouldHave(text(firstName))
                .shouldHave(text(lastName));
        page.getGenderTableRow()
                .shouldHave(text(gender.name()));
        page.getMobileTableRow()
                .shouldHave(text(mobileNumber));
    }

    @Test
    @DisplayName("Shouldn't show modal dialog upon submitting empty fields")
    public void submitNothing() {
        page.clickSubmitButton();

        WebElementCondition required = cssValue("required", "");

        page.getFirstNameForm().shouldHave(required);
        page.getLastNameForm().shouldHave(required);
        page.getPhoneNumberForm().shouldHave(required);
        page.getOtherRadio().shouldHave(required);
        page.getMaleRadio().shouldHave(required);
        page.getFemaleRadio().shouldHave(required);

        page.getStudentNameTableRow().shouldNot(exist);
        page.getDateOfBirthTableRow().shouldNot(exist);
        page.getMobileTableRow().shouldNot(exist);
        page.getGenderTableRow().shouldNot(exist);
    }
}
