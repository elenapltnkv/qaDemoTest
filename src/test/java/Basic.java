import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.HashMap;
import java.util.Map;

public class Basic {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void openPage() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy= String.valueOf(PageLoadStrategy.EAGER);
        Configuration.timeout = 10000;
        Configuration.remote = "http://45.9.40.101:4445/wd/hub/";

        DesiredCapabilities capabilities =  new DesiredCapabilities();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities= capabilities;
    }

    @BeforeEach
    public void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
