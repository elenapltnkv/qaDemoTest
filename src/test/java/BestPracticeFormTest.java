
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



public class BestPracticeFormTest extends Basic{
BestPracticeForm form = new BestPracticeForm();



    @Test
    @Tag("simple")
    public void fillDateToForm(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        form.openPage();
        form.setName();
        form.setLastName();
        form.setEmail();
        form.chooseJender("Female");
        form.setUserNumber();
        form.clickDateOfBirh("14", "January", "2014");
        form.setHobby("Reading");
        form.setAddres();
        form.submitForm();
        form.compareDateForm();
        System.out.println("end tests");
    }


}
