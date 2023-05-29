package com.example.promotion;

import com.example.promotion.enums.ResponseEnum;

import jakarta.xml.ws.Response;

public class PromoException extends Exception{
    protected int errorCode;

    protected String errorMsg;

    public PromoException() {
        super();
    }

    public PromoException(ResponseEnum err) {
        super(err.getMsg());
        this.errorCode = err.getStatus();
        this.errorMsg = err.getMsg();
    }

    public PromoException(ResponseEnum err, Throwable cause) {
        super(err.getMsg(), cause);
        this.errorCode = err.getStatus();
        this.errorMsg = err.getMsg();
    }

    public PromoException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public PromoException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public PromoException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
