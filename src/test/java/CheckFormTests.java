import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckFormTests {
    @Test
    @Disabled
    void successfulSearchTest() {
        open("https://ya.ru/");
        $("[id=text]").setValue("World of Warcraft").pressEnter();
        $("[id=search-result]").shouldHave(text("https://worldofwarcraft.blizzard.com/ru-ru/"));
    }

    @Test
    void successfulCapchaTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=captcha-form]").parent().shouldHave(text("Об этой странице"));
    }
}
