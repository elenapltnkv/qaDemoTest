import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.randomString;

public class BaseTest  extends Basic{
    RandomUtils utils = new RandomUtils();
    @Test
    public void addStudentNameTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(randomString(8));
        $("#lastName").setValue(randomString(10));
        $("#userEmail").setValue(randomString(5)+"@ya.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("79971235228");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--016").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("15 Seryur Angfef");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    }
}
