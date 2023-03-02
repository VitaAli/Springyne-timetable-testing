package it.academy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateDataUtils {

    public static String generateRandomModuleNumber() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return "random" + randomNum;
    }
}
