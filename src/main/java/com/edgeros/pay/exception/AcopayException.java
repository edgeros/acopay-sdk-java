package com.edgeros.pay.exception;

/**
 * Acopay API: Acopay Exception
 *
 * @since 1.0.0
 */
public class AcopayException extends Exception {

    private static final long serialVersionUID = -994760070063824300L;

    private String errCode;

    private String errMsg;

    public AcopayException() {
        super();
    }

    public AcopayException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcopayException(String message) {
        super(message);
    }

    public AcopayException(Throwable cause) {
        super(cause);
    }

    public AcopayException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
