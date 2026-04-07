package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitRegComponent {

    private final SelenideElement MODAL_HEADER = $(".modal-header");
    private final SelenideElement MODAL_BODY_TABLE = $(".table-responsive");


    public SubmitRegComponent checkModalWindow() {
        MODAL_HEADER.should(Condition.appear);
        MODAL_HEADER.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public SubmitRegComponent checkModalTable(String key, String value) {
        MODAL_BODY_TABLE.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

}
