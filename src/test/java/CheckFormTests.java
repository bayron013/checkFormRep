import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CheckFormTests {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";

    }

    @Test
    void CheckFormTest() {

        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        $("#firstName").setValue("Vladick");
        $("#lastName").setValue("Simba");
        $("#userEmail").setValue("winwin@maaal.zet");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("79554433222");
        $("#dateOfBirthInput").click();
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

        $("text=Student Name").shouldHave(text("Vladick Simba"));




// Попытки настроить календарь
//        $("react-datepicker__year-select select").click();
//        $$(".react-datepicker__year-option").findBy(text("1989")).click();
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $$(".react-datepicker__day").findBy(text(day)).click();





    }
}
