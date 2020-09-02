package com.example.SeleniumCleverbotTests.TestSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void beforeCLass() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
    }


}
