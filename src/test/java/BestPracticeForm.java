import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.components.RegistrationModalResult;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BestPracticeForm {
    CalendarComponent component = new CalendarComponent();
    RegistrationModalResult result = new RegistrationModalResult();


    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String adress = faker.address().streetAddress();


    public void openPage() {
        open("/automation-practice-form");
    }

    public void setName() {
        $("#firstName").setValue(name);
    }

    public void setLastName() {
        $("#lastName").setValue(lastName);
    }

    public void setEmail() {
        $("#userEmail").setValue(email);
    }

    public void chooseJender() {
        $("#genterWrapper").$(byText("Female")).click();
    }

    public void setUserNumber() {
        $("#userNumber").setValue(phoneNumber);
    }

    public void clickDateOfBirh(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        component.setDate(day, month, year);

    }

    public void setHobby() {
        $("#hobbiesWrapper").$(byText("Reading")).click();
    }

    public void setAddres() {
        $("#currentAddress").setValue(adress);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#submit").click();
    }

    public void submitForm() {
        result.verifyModal();
        //result.veryfyResultText();

    }

    public void compareDateForm() {
        result.veryfyResultText("Student Name",  name+ " "+ lastName);
        result.veryfyResultText("Student Email", email);
        result.veryfyResultText("Gender", "Female");
        result.veryfyResultText("Mobile",phoneNumber);
        result.veryfyResultText("Date of Birth", "Date of Birth 14 January,2014");
        result.veryfyResultText("Hobbies", "Reading");
        result.veryfyResultText("Address", adress);


    }


}
