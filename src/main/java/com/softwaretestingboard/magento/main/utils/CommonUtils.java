package com.softwaretestingboard.magento.main.utils;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.function.Function;

public class CommonUtils {

    private static final Faker FAKER = new Faker();

    /**
     * Generates a random string of letters, optionally converting them to uppercase.
     *
     * @param length      the length of the generated string
     * @param isUpperCase whether to convert the string to uppercase
     * @return the generated string
     */
    public static String generateRandomString(int length, boolean isUpperCase) {
        String randomString = FAKER.lorem().characters().substring(0, length);
        return isUpperCase ? randomString.toUpperCase() : randomString;
    }

    /**
     * Generates a random password that includes a special character and is 12 characters long.
     *
     * @return the generated password
     */
    public static String generateRandomPassword() {
        Random random = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+-=[]{},.<>/?";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(letters.length());
            password.append(letters.charAt(randomIndex));
        }
        int randomIndex = random.nextInt(specialChars.length());
        password.append(specialChars.charAt(randomIndex));
        return password.toString();
    }

    /**
     * Generates a random integer between min and max (inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return the generated integer
     */
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String generateRandomFirstName() {
        return withFaker(faker -> faker.name().firstName());
    }

    public static String generateRandomLastName() {
        return withFaker(faker -> faker.name().lastName());
    }

    public static String generateRandomStreetName() {
        return withFaker(faker -> faker.address().streetName());
    }

    public static String generateRandomCountry() {
        return withFaker(faker -> faker.country().name());
    }

    public static String generateRandomPhoneNumber() {
        return withFaker(faker -> faker.phoneNumber().phoneNumber());
    }

    public static String generateRandomCity() {
        return withFaker(faker -> faker.address().cityName());
    }

    public static String generateRandomState() {
        return withFaker(faker -> faker.address().state());
    }

    public static String generateRandomZipCode() {
        return withFaker(faker -> faker.address().zipCode());
    }

    public static String generateRandomQuote() {
        return withFaker(faker -> faker.gameOfThrones().quote());
    }

    public static String generateRandomEmailAddress() {

        return withFaker(faker -> faker.internet().emailAddress());
    }

    private static <T> T withFaker(Function<FakerWrapper, T> function) {
        try (FakerWrapper faker = new FakerWrapper()) {
            return function.apply(faker);
        }
    }

    private static class FakerWrapper extends Faker implements AutoCloseable {
        @Override
        public void close() {
        }
    }

    //TODO: Check out how the created methods give results here.
    public static void main(String[] args) {
        System.out.println(generateRandomFirstName());
        System.out.println(generateRandomLastName());
        System.out.println(generateRandomStreetName());
        System.out.println(generateRandomCountry());
        System.out.println(generateRandomPhoneNumber());
        System.out.println(generateRandomCity());
        System.out.println(generateRandomState());
        System.out.println(generateRandomZipCode());
        System.out.println(generateRandomQuote());
        System.out.println(generateRandomEmailAddress());
        System.out.println(generateRandomString(20, false));
        System.out.println(generateRandomString(15, true));
        System.out.println(generateRandomNumber(10, 100));
        System.out.println(generateRandomPassword());
    }
}

