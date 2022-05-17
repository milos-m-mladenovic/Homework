package com.projectname.api.client.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

    public static Boolean setRandomCompletedState() {
        ArrayList<Boolean> boolValue = new ArrayList<>();
        boolValue.add(false);
        boolValue.add(true);
        return boolValue.get(RandomUtils.nextInt(0, boolValue.size()));
    }

    public static String setRandomTitleName() {
        return Faker.instance().book().title();
    }

    public static String setDueDate() {
        return "2022-04-04T05:37:01.389Z";
    }

    public static  String setExcerpt() { return "Edit excerpt"; }

    public static String setBookDescription() { return Faker.instance().book().genre(); }

    public static String setPublishDate() { return "1900-04-10T12:32:04.324768+00:00"; }

    public static int setPageCount() { return RandomStringGenerator.createRandomWholeNumber(100, 400); }

    public static String setRandomUsername() { return Faker.instance().name().username(); }

    public static String setRandomPassword() { return RandomStringGenerator.createRandomStringAlphanumericWithLen(8); }

}
