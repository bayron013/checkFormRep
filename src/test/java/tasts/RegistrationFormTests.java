package tasts;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class RegistrationFormTests extends TestBase {

    private String getFormattedSpace(String val1, String val2) {
        return String.format("%s %s", val1, val2);
    }
    private String getFormattedComma(String val1, String val2) {
        return String.format("%s, %s", val1, val2);
    }


    @Test
    void checkFormTest() {

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();


        // Ввод данных
        checkFormPages.inputFirstName(dto.name)
                .inputLastName(dto.surName)
                .inputEmail(dto.email)
                .setGender(dto.gender)
                .inputNumber(dto.phoneNumber)
                .setDateOfBirth(dto.birthsYear, dto.birthsMounth, dto.birthsDay)
                .subjectInput(dto.subject1)
                .subjectInput(dto.subject2)
                .setHobby(dto.hobby1)
                .setHobby(dto.hobby2)
                .inputFile(dto.uploadFileName)
                .inputAddress(dto.address)
                .setStateAndCity(dto.region, dto.city)
        // Подтверждение
                .pressSubmit();

        // Проверки формы
        submitRegComponent.checkModalWindow()
                .checkModalTable("Student Name", getFormattedSpace(dto.name, dto.surName))
                .checkModalTable("Student Email", dto.email)
                .checkModalTable("Gender", dto.gender)
                .checkModalTable("Mobile", dto.phoneNumber)
                .checkModalTable("Date of Birth", dto.fullBirthsDate)
                .checkModalTable("Subjects", getFormattedComma(dto.subject1, dto.subject2))
                .checkModalTable("Hobbies", getFormattedComma(dto.hobby1, dto.hobby2))
                .checkModalTable("Picture", dto.uploadFileName)
                .checkModalTable("Address", dto.address)
                .checkModalTable("State and City", getFormattedSpace(dto.region, dto.city));

    }


    @Test
    void positiveMinimumFieldsTest() {

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();

        // Ввод данных
        checkFormPages.inputFirstName(dto.name)
                .inputLastName(dto.surName)
                .setGender(dto.gender)
                .inputNumber(dto.phoneNumber)
        // Подтверждение
                .pressSubmit();

        // Проверки формы
        submitRegComponent.checkModalWindow()
                .checkModalTable("Student Name", getFormattedSpace(dto.name, dto.surName))
                .checkModalTable("Gender", dto.gender)
                .checkModalTable("Mobile", dto.phoneNumber);

    }


    @Test
    void negativeWrongEmailTest(){

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();

        // Ввод данных
        checkFormPages.inputEmail(dto.wrongEmail)

        // Подтверждение
                .pressSubmit();

        // Проверки формы
        checkFormPages.incorrectEmail();

    }


    @Test
    void negativeEmptyFieldsTest(){

        // Открытие сайта
        checkFormPages.openPage()
                .findTestPage();

        // Подтверждение
        checkFormPages.pressSubmit();

        // Проверки формы
        checkFormPages.incorrectForm(dto.gender);

    }
}
