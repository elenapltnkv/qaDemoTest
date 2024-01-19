import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import pages.RegistrationPage;

public class Basic {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void openPage() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= String.valueOf(PageLoadStrategy.EAGER);


    }
}
