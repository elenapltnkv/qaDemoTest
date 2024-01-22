
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;


public class StepsTest extends Basic{
BestStepLambda steps = new BestStepLambda();
@Feature("Проверка отображения текста на главной странице формы")
@Link(value = "на странице", url="https://demoqa.com")
@Owner("samigullaeva.ea")
@DisplayName("Открытие страницы с формой")
@Test
public void openFormPage(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    steps.openPageTest();
    steps.openPageTestShouldHaveText();
    steps.takeScreenshot();
    attachment("Source", webdriver().driver().source());
}

    @Feature("Проверка заполнения формы:")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка результатов заполнения формы")
    @Test
    public void fillDateToForm(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openPageTest();
        steps.setName();
        steps.setLastName();
        steps.setEmail();
        steps.chooseJender("Female");
        steps.setUserNumber();
        steps.clickDateOfBirh("14", "January", "2014");
        steps.setHobby("Reading");
        steps.setAddres();
        steps.submitForm();
        steps.compareDateForm();

    }


}
