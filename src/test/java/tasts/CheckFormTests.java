package tasts;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckFormTests extends TestBase {


    @Test
    void checkFormTest() {

        // Открытие сайта
        open("");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#firstName").setValue(name);
        $("#lastName").setValue(surName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1989']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='9']").click();
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Ошибка в браузере.png");
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").click();
        $$("[role='option']").findBy(text("Uttar Pradesh")).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $$("[role='option']").findBy(text("Agra")).shouldBe(visible).click();
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + surName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("06 October,1989"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("History, Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Ошибка в браузере.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));


    }


    @Test
    void positiveMinimumFieldsTest() {

        // Открытие сайта
        open("");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#firstName").setValue(name);
        $("#lastName").setValue(surName);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + surName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
    }


    @Test
    void negativeWrongEmailTest(){

        // Открытие сайта
        open("");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#userEmail").setValue("quqaresh@rambler.1");
        $("#submit").click();

        // Проверки формы
        $("#userEmail").shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));
    }


    @Test
    void negativeEmptyFieldsTest(){

        // Открытие сайта
        open("");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        // Ввод данных
        $("#submit").click();

        // Проверки формы
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        $("#userNumber").shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));
    }
}
