package Helpers;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomData {
    Faker faker = new Faker();
    static Random random = new Random();

    public static int randomNumber(int bound) {
        int randomNumber = random.nextInt(bound);

        return randomNumber;
    }
}
