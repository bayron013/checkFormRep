package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitRegComponent {

    private SelenideElement modalHeader = $(".modal-header");
    private SelenideElement modalBodyTable = $(".table-responsive");


    public SubmitRegComponent checkModalWindow() {
        modalHeader.should(Condition.appear);
        modalHeader.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public SubmitRegComponent checkModalTable(String key, String value) {
        modalBodyTable.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

}
