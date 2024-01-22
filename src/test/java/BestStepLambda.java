import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.github.javafaker.Faker;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.components.CalendarComponent;
import pages.components.RegistrationModalResult;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class BestStepLambda {
    CalendarComponent component = new CalendarComponent();
    RegistrationModalResult result = new RegistrationModalResult();


    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String adress = faker.address().streetAddress();

    public void openPageTest() {
        step("Открыть главную страницу.", () ->
        {
            open("/automation-practice-form");


        });
    }


    public void openPageTestShouldHaveText() {
        step("Проверить, что на главной странице отображается текст 'Practice Form'", () ->
        {
            $(".main-header").shouldHave(text("Practice Form"));


        });

    }


    public void setName() {
        step("Заполнить поле имя", () ->
        {
            $("#firstName").setValue(name);
        });
    }

    public void setLastName() {
        step("Заполнить поле фамилия", () ->
        {
            $("#lastName").setValue(lastName);
        });
    }

    public void setEmail() {
        step("Заполнить поле email", () ->
        {
            $("#userEmail").setValue(email);
        });
    }

    public void chooseJender(String sex) {
        step("Выбрать пол", () ->
        {
            $("#genterWrapper").$(byText(sex)).click();
        });
    }

    public void setUserNumber() {
        step("Заполнить поле номер телефона", () ->
        {
            $("#userNumber").setValue(phoneNumber);
        });
    }

    public void clickDateOfBirh(String day, String month, String year) {
        step("Выбрать дату рождения", () ->
        {
            $("#dateOfBirthInput").click();
            component.setDate(day, month, year);
        });
    }

    public void setHobby(String hobby) {
        step("Выбрать хобби", () -> {

            $("#hobbiesWrapper").$(byText(hobby)).click();
        });
    }

    public void setAddres() {
        step("Заполнить адрес", () -> {
            $("#currentAddress").setValue(adress);
            $("#state").click();
            $("#react-select-3-option-1").click();
            $("#submit").click();
        });
    }

    public void submitForm() {
        step("Проверить, что при добавлении появилась надпись 'Thanks for submitting the form'", () -> {
            result.verifyModal();
        });
    }

    public void compareDateForm() {
        step("Проверить заполнение формы", () -> {
            result.veryfyResultText("Student Name", name + " " + lastName);
            result.veryfyResultText("Student Email", email);
            result.veryfyResultText("Gender", "Female");
            result.veryfyResultText("Mobile", phoneNumber);
            result.veryfyResultText("Date of Birth", "Date of Birth 14 January,2014");
            result.veryfyResultText("Hobbies", "Reading");
            result.veryfyResultText("Address", adress);
            takeScreenshot();

        });
    }

    @Attachment(value="screenshot", type="image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }


}
