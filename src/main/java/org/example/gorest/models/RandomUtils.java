package org.example.gorest.models;

import net.datafaker.Faker;

public class RandomUtils {
    private static Faker faker = new Faker();

    public static Users generateUsers(){
        Users users = new Users();
        users.setName(faker.name().firstName());
        users.setEmail(faker.internet().emailAddress());
        users.setGender(faker.gender().binaryTypes());
        users.setStatus(faker.options().option("active","inactive"));
        return users;
    }
}
