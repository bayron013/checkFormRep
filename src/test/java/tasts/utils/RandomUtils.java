package tasts.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;

public class RandomUtils {

    public static String getCityInState(String val) {
        Faker faker = new Faker();
        return switch (val) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public static String getWrongEmail() {
        return String.format("%s@%s.1", getRandomString(8), getRandomString(5));
    }

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));

        return result.toString();
    }


}
