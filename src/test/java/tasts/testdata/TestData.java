package tasts.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

import static tasts.utils.RandomUtils.*;

public class TestData {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    public String name = fakerRu.name().firstName();
    public String surName = fakerRu.name().lastName();
    public String email = faker.internet().emailAddress();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String gender = getRandomGender();
    public String address = fakerRu.address().fullAddress();
    public String subject1 = getRandomSubject();
    public String hobby1 = getRandomHobby();
    public String uploadFileName = "Ошибка в браузере.png";
    public String birthsDay = Integer.toString(getRandomInt(10, 28));
    public String birthsMounth = getRandomMounth();
    public String birthsYear = Integer.toString(faker.number().numberBetween(1900,2100));
    public String fullBirthsDate = String.format("%s %s,%s", birthsDay, birthsMounth, birthsYear);
    public String region = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCityInState(region);

    public String wrongEmail = "quqaresh@rambler.1";

}
