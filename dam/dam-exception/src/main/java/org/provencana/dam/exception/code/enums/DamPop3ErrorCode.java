package org.provencana.dam.exception.code.enums;

import org.provencana.dam.exception.definition.ErrorCode;

public enum DamPop3ErrorCode implements ErrorCode {

    ERROR_CONNECTING_SERVER("10"),
    ERROR_LOGIN_SERVER("20"),
    ERROR_LOGOUT_SERVER("30"),
    ERROR_RETRIEVE_MESSAGES("40"),
    ERROR_NO_MESSAGES("50"),
    ERROR_ON_GET_MESSAGE("60");

    private final String errorCode;

    DamPop3ErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCode() {
        return DamExceptionEnumDefinition.buildCode(DamExceptionEnumDefinition.POP3, errorCode);
    }

}
