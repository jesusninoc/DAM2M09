package org.provencana.dam.exception;

import org.provencana.dam.exception.definition.ErrorCode;
import org.provencana.dam.exception.type.enums.ErrorSeverity;

import java.util.Arrays;

public class DamPop3Exception extends Exception {


    private static final long serialVersionUID = 2123590074135089614L;

    private final ErrorCode errorCode;

    private final ErrorSeverity errorSeverity;

    private Object[] params = null;

    public DamPop3Exception(final String message, final ErrorCode code, final ErrorSeverity errorSeverity, final Object... params) {

        this(new Exception(message), message, code, errorSeverity, params);
    }

    public DamPop3Exception(final Throwable cause, final String message, final ErrorCode code, final ErrorSeverity errorSeverity, final Object... params)
    {
        super(message, cause);

        this.errorCode = code;
        this.errorSeverity = errorSeverity;
        this.params = params;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ErrorSeverity getErrorSeverity() {
        return errorSeverity;
    }

    public Object[] getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "damPop3Exception{" +
                "errorCode=" + errorCode +
                ", errorSeverity=" + errorSeverity +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
