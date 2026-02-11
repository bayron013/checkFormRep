import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CheckFormTests {

    @BeforeAll
    static void confBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Disabled
    void successfulSearchTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Vladick");
        $("#lastName").setValue("Simba");
        $("#userEmail").setValue("winwin@maaal.zet");
        $("#gender-radio-1");
        $("#gender-radio-2");
        $("#gender-radio-3");
        $("#userNumber");
        $("#dateOfBirthInput");
        $(".react-datepicker__day react-datepicker__day--010");
        $(".subjects-auto-complete__placeholder css-1wa3eu0-placeholder");
        $("#hobbies-checkbox-1");
        $("#hobbies-checkbox-2");
        $("#hobbies-checkbox-3");
        $("#uploadPicture");
        $("#currentAddress");
        $("#state");
        $("#city");


    }
}
