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
    public static String gender = "Male";
    public static String address = "Приморское шоссе 15, к2";
    public static String subject1 = "History", subject2 = "Maths";
    public static String hobby1 = "Sports", hobby2 = "Reading";
    public static String uploadFile = "Ошибка в браузере.png";
    public static String birthsDay = "06", birthsMounth = "October", birthsYear = "1989";
    public static String region = "Uttar Pradesh", city = "Agra";



}
