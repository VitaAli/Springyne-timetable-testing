package it.academy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateDataUtils {

    public static String generateRandomNumber() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return "number" + randomNum;
    }

    public static String generateRandomName() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return "name" + randomNum;
    }
}
