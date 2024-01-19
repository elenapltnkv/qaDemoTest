package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationModalResult;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    CalendarComponent component = new CalendarComponent();
    RegistrationModalResult modalResult = new RegistrationModalResult();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            currentAddress = $("#currentAddress");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage getGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage getDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        component.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage currentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage getState() {
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#submit").click();
        return this;
    }

    public RegistrationPage getRegistrationModal() {
        modalResult.verifyModal();
        return this;
    }

    public RegistrationPage getverifyResult(String key, String value) {
        modalResult.veryfyResultText(key, value);
        return this;
    }
}
