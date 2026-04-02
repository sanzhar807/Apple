package org.example.demoQa.utils;

import net.datafaker.Faker;
import org.example.demoQa.models.UserPractiseForm;
import org.example.demoQa.models.UserWebTables;

public class RandomUtils {
    private static Faker faker = new Faker();

    public static UserPractiseForm generatePracticeFormUser(){
        UserPractiseForm userPractiseForm = new UserPractiseForm();
        userPractiseForm.setFirsName(faker.name().firstName());
        userPractiseForm.setLastName(faker.name().lastName());
        userPractiseForm.setEmail(faker.internet().emailAddress());
       userPractiseForm.setGender(faker.options().option("Male","Female","Other"));
     //  userPractiseForm.setSubject(List.of(faker.number().digits(4)));
       userPractiseForm.setPhoneNumber(String.valueOf(faker.phoneNumber().subscriberNumber(10)));
       userPractiseForm.setHobbies(faker.options().option("Sports","Reading","Music"));
       userPractiseForm.setCurrentAddress(faker.address().streetAddress());
        return userPractiseForm;
    }

    public static UserWebTables generateWebTablesForm(){
        UserWebTables userWebTable = new UserWebTables();
        userWebTable.setFirstName(faker.name().firstName());
        userWebTable.setLastName(faker.name().lastName());
        userWebTable.setEmail(faker.internet().emailAddress());
        userWebTable.setAge(String.valueOf(faker.number().numberBetween(18,60)));
        userWebTable.setSalary(String.valueOf(faker.number().numberBetween(2500,7500)));
        userWebTable.setDepartment(faker.job().field());
        return userWebTable;
    }

    public int randomNumber(int size){
        return faker.number().numberBetween(0,14);
    }

    public int randomNumberOneToFour(){
        return faker.number().numberBetween(1,4);
    }


    public static void main(String[] args) {
        UserPractiseForm userPractiseForm = generatePracticeFormUser();
        System.err.println(userPractiseForm);
    }


}
