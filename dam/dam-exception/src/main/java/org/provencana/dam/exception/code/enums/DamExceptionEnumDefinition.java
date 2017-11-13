package org.provencana.dam.exception.code.enums;

public class DamExceptionEnumDefinition {

    public final static String POP3 = "10000";

    public static String buildCode(final String code, final String errorCode) {
        return String.valueOf(Integer.valueOf(code) + Integer.valueOf(errorCode));
    }
}
