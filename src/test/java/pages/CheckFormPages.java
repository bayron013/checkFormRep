package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class CheckFormPages {


    // Elements
    private SelenideElement userNameInput = $("#firstName");
    private SelenideElement dayOfBirthInput = $("#dateOfBirthInput");



    // Actions
    public CheckFormPages openPage() {
        open("");
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
            """);
        return this;
    }

    public CheckFormPages findTestPage() {
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        return this;
    }

    public CheckFormPages inputFirstName(String name) {
        userNameInput.setValue(name);

        return this;
    }


    public CheckFormPages setDateOfBirth(String year, String mounth, String day) {
        dayOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(year, mounth, day);

        return this;

    }

}
