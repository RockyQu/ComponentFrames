package me.router.compiler.utils;

import java.util.Locale;

public class RouterCompilerUtils {

    public static String format(String value, Object... values) {
        return String.format(Locale.CHINA, value, values);
    }
}