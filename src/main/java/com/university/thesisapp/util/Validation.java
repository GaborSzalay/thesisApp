package com.university.thesisapp.util;

/**
 * Created by Gábor on 2015.07.13..
 */
public class Validation {
    public static boolean Empty(Object object) {
        boolean empty = false;
        if (object == null) {
            empty = true;
        }
        return empty;
    }
}
