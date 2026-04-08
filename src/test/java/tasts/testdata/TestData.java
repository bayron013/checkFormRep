package tasts.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

import static tasts.utils.RandomUtils.getCityInState;
import static tasts.utils.RandomUtils.getWrongEmail;

public class TestData {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    public String name = fakerRu.name().firstName();
    public String surName = fakerRu.name().lastName();
    public String email = faker.internet().emailAddress();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String gender = faker.options().option("Male", "Female", "Other");
    public String address = fakerRu.address().fullAddress();
    public String subject1 = faker.options().option("Hindi", "English", "Maths", "Physics",
            "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts",
            "Social Studies", "History", "Civics");
    public String hobby1 = faker.options().option("Sports", "Reading", "Music");
    public String uploadFileName = "Ошибка в браузере.png";
    public String birthsDay = Integer.toString(faker.number().numberBetween(1, 28));
    public String birthsMounth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String birthsYear = Integer.toString(faker.number().numberBetween(1900, 2100));
    public String fullBirthsDate = String.format("%s %s,%s", birthsDay, birthsMounth, birthsYear);
    public String region = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCityInState(region);

    public String wrongEmail = getWrongEmail();

}
