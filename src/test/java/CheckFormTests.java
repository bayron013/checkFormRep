import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckFormTests {


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


    @Test
    void CheckFormTest() {

        // Открытие сайта
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#firstName").setValue("Vladick");
        $("#lastName").setValue("Simba");
        $("#userEmail").setValue("winwin@maaal.zet");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7955443322");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1989']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='9']").click();
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-3").click();
        File imageFile = new File("src/test/resources/Ошибка в браузере.png");
        $("#uploadPicture").uploadFile(imageFile);
        $("#currentAddress").setValue("Приморское шоссе 15, к2");
        $("#react-select-3-input").click();
        $$("[role='option']").findBy(text("Uttar Pradesh")).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $$("[role='option']").findBy(text("Agra")).shouldBe(visible).click();
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vladick Simba"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("winwin@maaal.zet"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7955443322"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 October,1989"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("History, Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Ошибка в браузере.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Приморское шоссе 15, к2"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));

//      Попытки использовать календарь
//      1)
//        $("react-datepicker__year-select select").click();
//        $$(".react-datepicker__year-option").findBy(text("1989")).click();
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $$(".react-datepicker__day").findBy(text(day)).click();

//      2)
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__year-select").click();
//        $("option[value='1989']").click();
//        $(".react-datepicker__month-select").click();
//        $("option[value='9']").click();
//        $(".react-datepicker__week").
//                $(".react-datepicker__day react-datepicker__day--006").click();

    }


    @Test
    void positiveMinimumFieldsTest() {

        // Открытие сайта
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#firstName").setValue("Svetic");
        $("#lastName").setValue("Semic'vetic");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("7955443322");
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Svetic Semic'vetic"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7955443322"));
    }


    @Test
    void negativeWrongEmailTest(){

        // Открытие сайта
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#userEmail").setValue("quqaresh@rambler.1");
        $("#submit").click();
        $("#userEmail").shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));
    }


    @Test
    void negativeEmptyFieldsTest(){

        // Открытие сайта
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#submit").click();
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        $("#userNumber").shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));
    }
}
