package tests;

import java.util.ArrayList;
import java.util.Collections;
import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String userEmail = faker.internet().emailAddress();
    String invalidEmail = String.format("%s@%s", faker.dog().name(), faker.internet().domainSuffix());

            String userGender = setRandomValue("Male", "Female", "Other");
    String userNumber = String.valueOf(faker.number().numberBetween(7_000_000_000L, 8_999_999_999L));
    String userBirthYear = String.valueOf(faker.number().numberBetween(1924, 2010));
    String userBirthMonth = setRandomValue("February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December");
    String userBirthDay = String.valueOf(faker.number().numberBetween(1,28));
    String subject = setRandomValue("Accounting", "Arts", "Biology", "Chemistry", "Computer Science", "Commerce",
            "Civics", "English", "Economics", "Hindi", "History", "Maths", "Physics", "Social Studies");
    String hobby = setRandomValue("Sports", "Reading", "Music");
    String picturePath = setRandomValue("img/avatar.png", "img/avatar2.jpg");
    String pictureName = picturePath.substring(picturePath.lastIndexOf("/") + 1);
    String currentAddress = faker.address().streetAddress();
    String permanentAddress = faker.address().streetAddress();

    String state = setRandomValue("Uttar Pradesh", "NCR", "Haryana", "Rajasthan");
    String city = setRandomCity(state);

    public String setRandomValue (String ... strings){
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values,strings);
        String item = values.get(faker.number().numberBetween(0, values.size()-1));
        return item;
    }

    public String setRandomCity (String state) {
        return switch (state) {
            case "Uttar Pradesh" -> setRandomValue("Agra", "Lucknow", "Merrut");
            case "NCR" -> setRandomValue("Delhi", "Gurgaon", "Noida");
            case "Haryana" -> setRandomValue("Karnal", "Panipat");
            case "Rajasthan" -> setRandomValue("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
