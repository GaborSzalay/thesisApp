package com.university.thesisapp.util;

import java.util.Collection;

/**
 * Created by Gábor on 2015.07.13..
 */
public class Validation {
    public static boolean empty(Collection<? extends Object> collection) {
        boolean empty = false;
        if (collection == null) {
            empty = true;
        } else if (collection.size() == 0) {
            empty = true;
        }
        return empty;
    }

    public static boolean notEmpty(Collection<? extends Object> collection) {
        return !empty(collection);
    }

    public static boolean empty(Object object) {
        boolean empty = false;
        if (object == null) {
            empty = true;
        }
        return empty;
    }

    public static boolean notEmpty(Object object) {
        return !empty(object);
    }
}
