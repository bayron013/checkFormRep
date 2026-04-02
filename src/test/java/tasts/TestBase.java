package tasts;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";

    }

    @AfterEach()
    void closeBrowser() {
        closeWebDriver();
    }

    // Переиспользуемые переменные
    public static String name = "Vladick";
    public static String surName = "Simba";
    public static String email = "winwin@maaal.zet";
    public static String phoneNumber = "7955443322";
    public static String address = "Приморское шоссе 15, к2";

}
