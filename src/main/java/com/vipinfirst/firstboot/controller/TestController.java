package com.vipinfirst.firstboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;


public class TestController {
    private static final Logger FBLogger = LoggerFactory.getLogger("firstboot");


    public static void TestFunction() {

        String str = "hellohihello";

        HashSet<Character> processed = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char match = str.charAt(i);

            if (processed.contains(match)) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (match == str.charAt(j)) {
                    count++;
                }
            }

            FBLogger.info(match + " occurs " + count + " time(s)");

            processed.add(match);
        }
    }



}
