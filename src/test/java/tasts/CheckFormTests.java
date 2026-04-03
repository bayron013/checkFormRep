package tasts;

import org.junit.jupiter.api.Test;
import pages.CheckFormPages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckFormTests extends TestBase {

    CheckFormPages checkFormPages = new CheckFormPages();

    @Test
    void checkFormTest() {

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage()
                .inputFirstName(name);


        // Ввод данных
        checkFormPages.inputFirstName(name);
        $("#lastName").setValue(surName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        checkFormPages.setDateOfBirth(birthsYear, birthsMounth, birthsDay);

        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(uploadFile);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").click();
        $$("[role='option']").findBy(text(region)).shouldBe(visible).click();
        $("#react-select-4-input").click();
        $$("[role='option']").findBy(text(city)).shouldBe(visible).click();
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + surName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text(birthsDay + " " + birthsMounth + "," + birthsYear));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject1 + ", " + subject2));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby1 + ", " + hobby2));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(uploadFile));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(region + " " + city));


    }


    @Test
    void positiveMinimumFieldsTest() {

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();

        // Ввод данных
        $("#firstName").setValue(name);
        $("#lastName").setValue(surName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#submit").click();

        // Проверки формы
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + surName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
    }


    @Test
    void negativeWrongEmailTest(){

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();

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
        checkFormPages.openPage()
                .findTestPage();

        // Ввод данных
        $("#submit").click();

        // Проверки формы
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#genterWrapper").$(byText(gender)).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        $("#userNumber").shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));
    }
}
