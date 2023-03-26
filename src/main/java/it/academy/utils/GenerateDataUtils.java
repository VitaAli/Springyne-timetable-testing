package it.academy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateDataUtils {

    public static String generateRandomNum() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return String.valueOf(randomNum);
    }
}
