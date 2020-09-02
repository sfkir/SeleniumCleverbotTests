package com.example.SeleniumCleverbotTests.Utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakeData {
    private static Faker faker = new Faker();
    private static FakeValuesService fakeValuesService = new FakeValuesService(Locale.ENGLISH, new RandomService());

    public static String generateRandomUsername() {
        return faker.name().username();
    }

    public static String generateRandomFullName() {
        return faker.name().fullName();
    }

    public static String generateRandomMessage() {
        return faker.lorem().characters(10);
    }


}
