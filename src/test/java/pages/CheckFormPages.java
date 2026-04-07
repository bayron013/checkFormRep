package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckFormPages {

    private final SelenideElement USER_NAME_INPUT = $("#firstName");
    private final SelenideElement USER_LAST_NAME_INPUT = $("#lastName");
    private final SelenideElement USER_EMAIL_INPUT = $("#userEmail");
    private final SelenideElement GENDER_CONTAINER = $("#genterWrapper");
    private final SelenideElement USER_NUMBER_INPUT = $("#userNumber");
    private final SelenideElement DAY_OF_BIRTH_INPUT = $("#dateOfBirthInput");
    private final SelenideElement USER_SUBJECT_INPUT = $("#subjectsInput");
    private final SelenideElement HOBBY_CONTAINER = $("#hobbiesWrapper");
    private final SelenideElement FILE_CONTAINER = $("#uploadPicture");
    private final SelenideElement USER_ADDRESS_INPUT = $("#currentAddress");
    private final SelenideElement STATE_SELECT = $("#state");
    private final SelenideElement CITY_SELECT = $("#city");
    private final SelenideElement STATE_CITY_CONTAINER = $("#stateCity-wrapper");
    private final SelenideElement SUBMIT_BUTTON_ELELMENT = $("#submit");


    public CheckFormPages openPage() {
        open("");
        closeBanners();

        return this;
    }

    public void closeBanners() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

    }

    public CheckFormPages findTestPage() {
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        return this;
    }

    public CheckFormPages inputFirstName(String value) {
        USER_NAME_INPUT.setValue(value);

        return this;
    }

    public CheckFormPages inputLastName(String value) {
        USER_LAST_NAME_INPUT.setValue(value);

        return this;
    }

    public CheckFormPages inputEmail(String value) {
        USER_EMAIL_INPUT.setValue(value);

        return this;
    }

    public CheckFormPages setGender(String value) {
        GENDER_CONTAINER.$(byText(value)).click();

        return this;
    }

    public CheckFormPages inputNumber(String value) {
        USER_NUMBER_INPUT.setValue(value);

        return this;
    }

    public CheckFormPages subjectInput(String value) {
        USER_SUBJECT_INPUT.setValue(value).pressEnter();

        return this;
    }

    public CheckFormPages setHobby(String value) {
        HOBBY_CONTAINER.$(byText(value)).click();

        return this;
    }

    public CheckFormPages inputFile(String value) {
        FILE_CONTAINER.uploadFromClasspath(value);

        return this;
    }

    public CheckFormPages inputAddress(String value) {
        USER_ADDRESS_INPUT.setValue(value);

        return this;
    }

    public CheckFormPages setState(String value) {
        STATE_SELECT.click();
        STATE_CITY_CONTAINER.$(byText(value)).click();

        return this;
    }

    public CheckFormPages setCity(String value) {
        CITY_SELECT.click();
        STATE_CITY_CONTAINER.$(byText(value)).click();

        return this;
    }

    public CheckFormPages setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public void pressSubmit() {
        SUBMIT_BUTTON_ELELMENT.click();

    }

    public CheckFormPages setDateOfBirth(String year, String mounth, String day) {
        DAY_OF_BIRTH_INPUT.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(year, mounth, day);

        return this;

    }

    public CheckFormPages incorrectEmail() {
        USER_EMAIL_INPUT.shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));

        return this;
    }

    public CheckFormPages incorrectForm(String value) {
        USER_NAME_INPUT.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        GENDER_CONTAINER.$(byText(value))
                .shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        USER_NUMBER_INPUT.shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));

        return this;
    }

}
