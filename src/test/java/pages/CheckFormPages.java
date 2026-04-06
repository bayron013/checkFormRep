package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class CheckFormPages {

    // Elements
    private SelenideElement userNameInput = $("#firstName");
    private SelenideElement userLastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement dayOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement userSubjectInput = $("#subjectsInput");
    private SelenideElement hobbyContainer = $("#hobbiesWrapper");
    private SelenideElement fileContainer = $("#uploadPicture");
    private SelenideElement userAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");

    private SelenideElement submitButtonElelment = $("#submit");



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

    public CheckFormPages inputFirstName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public CheckFormPages inputLastName(String value) {
        userLastNameInput.setValue(value);

        return this;
    }

    public CheckFormPages inputEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public CheckFormPages setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public CheckFormPages inputNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public CheckFormPages subjectInput(String value) {
        userSubjectInput.setValue(value).pressEnter();

        return this;
    }

    public CheckFormPages setHobby(String value) {
        hobbyContainer.$(byText(value)).click();

        return this;
    }

    public CheckFormPages inputFile(String value) {
        fileContainer.uploadFromClasspath(value);

        return this;
    }

    public CheckFormPages inputAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public CheckFormPages setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public CheckFormPages setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public CheckFormPages setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public void pressSubmit() {
        submitButtonElelment.click();

    }


    public CheckFormPages setDateOfBirth(String year, String mounth, String day) {
        dayOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(year, mounth, day);

        return this;

    }

    public CheckFormPages incorrectEmail() {
        userEmailInput.shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));

        return this;
    }

    public CheckFormPages incorrectForm(String value) {
        userNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        genderContainer.$(byText(value))
                .shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        userNumberInput.shouldBe(match("background-image contains error icon",
                el -> el.getCssValue("background-image").contains("stroke='%23dc3545'")));

        return this;
    }


}
