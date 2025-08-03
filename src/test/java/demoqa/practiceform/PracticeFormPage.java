package demoqa.practiceform;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {

    private final SelenideElement firstNameForm = $("#firstName");
    private final SelenideElement lastNameForm = $("#lastName");
    private final SelenideElement phoneNumberForm = $("#userNumber");
    private final SelenideElement maleRadio = $x("//label[@for='gender-radio-1']");
    private final SelenideElement femaleRadio = $x("//label[@for='gender-radio-2']");
    private final SelenideElement otherRadio = $x("//label[@for='gender-radio-3']");
    private final SelenideElement submitButton = $("#submit");

    private final SelenideElement modalDialog = $x("");
    /** Contains BOTH first name AND last name of the student*/
    private final SelenideElement studentNameTableRow = $x("//table//tbody//tr[1]");
    private final SelenideElement genderTableRow = $x("//table//tbody//tr[3]");
    private final SelenideElement mobileTableRow = $x("//table//tbody//tr[4]");
    private final SelenideElement dateOfBirthTableRow = $x("//table//tbody//tr[5]");

    public PracticeFormPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    public SelenideElement getFirstNameForm() {
        return firstNameForm;
    }

    public SelenideElement getLastNameForm() {
        return lastNameForm;
    }

    public SelenideElement getPhoneNumberForm() {
        return phoneNumberForm;
    }

    public SelenideElement getMaleRadio() {
        return maleRadio;
    }

    public SelenideElement getFemaleRadio() {
        return femaleRadio;
    }

    public SelenideElement getOtherRadio() {
        return otherRadio;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getStudentNameTableRow() {
        return studentNameTableRow;
    }

    public SelenideElement getGenderTableRow() {
        return genderTableRow;
    }

    public SelenideElement getMobileTableRow() {
        return mobileTableRow;
    }

    public SelenideElement getDateOfBirthTableRow() {
        return dateOfBirthTableRow;
    }

    public void fillFirstNameForm(String firstName) {
        firstNameForm.click();
        firstNameForm.sendKeys(firstName);
    }

    public void fillLastNameForm(String lastName) {
        lastNameForm.click();
        lastNameForm.sendKeys(lastName);
    }

    public void fillPhoneNumberForm(String phoneNumber) {
        phoneNumberForm.click();
        phoneNumberForm.sendKeys(phoneNumber);
    }

    public void clickGenderRadio(StudentGender gender) {
        switch (gender) {
            case Male -> maleRadio.click();
            case Female -> femaleRadio.click();
            case Other -> otherRadio.click();
        }
    }

    public void clickSubmitButton() {
        submitButton.sendKeys(Keys.ENTER);
    }

    public SelenideElement getModalDialog() {
        return modalDialog;
    }
}
