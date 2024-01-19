package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomUtils {
    public static Faker faker = new Faker();
    public static String userName = faker.name().firstName(); // Emory
    public static String userSurname = faker.name().lastName(); // Barton
    public static String userFakeEmail = faker.internet().emailAddress();
    public static String phoneFakeNumber = faker.phoneNumber().subscriberNumber(10);
    public static String userAddress = faker.address().streetAddress();

    public static String randomString(int lenth) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();

        while (lenth > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            lenth--;
        }
        return result.toString();
    }

    public static String randomNumber(int lenth) {
        final String characters = "1234567890";
        StringBuilder result = new StringBuilder();

        while (lenth > 0) {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            lenth--;
        }
        return result.toString();
    }
}
