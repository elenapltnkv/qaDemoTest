import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import pages.RegistrationPage;

public class Basic {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void openPage() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= String.valueOf(PageLoadStrategy.EAGER);
        Configuration.remote = "http://45.9.40.101:4445/wd/hub/";
    }

    @BeforeEach
    public void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
