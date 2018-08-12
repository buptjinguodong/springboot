package com.imooc.frame.exception;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

public class CommonException extends Exception implements IndexedMessage {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(CommonException.class);

    public static final String LOG001 = "无法找到异常信息，code={0}，locale={1}";

    private String code;
    private Object[] params;
    private List<Locale> locales;

    public CommonException(String code, Throwable e,
                           List<Locale> locales, Object... params) {
        super(e);
        this.code = code;
        this.params = params;
        this.locales = locales;
    }

    public CommonException(String code, Throwable e, Object... params) {
        this(code, e, null, params);
    }

    public CommonException(String code, Object... params) {
        this(code, null, params);
    }

    public CommonException(Throwable e) {
        this(null, e);
    }

    public CommonException() {
    }

    public String getMessage() {
        return assembleMessage(getLogMessage());
    }

    private String assembleMessage(String exceptionMessage) {
        return new StringBuilder("[ERRORCODE=")
                .append(getCode())
                .append("][")
                .append(StringUtils.hasText(exceptionMessage) ? exceptionMessage
                    : "").append("]").toString();
    }

    private String getLogMessage() {
        String message = LogExceptionMessage.getMessage(getCode());
        if ((message != null) && (params != null) && (params.length > 0)) {
            MessageFormat mf = new MessageFormat(message);
            message = mf.format(params);
        }

        return StringUtils.hasText(message) ? message : "";
    }



    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public Object[] getParameters() {
        return new Object[0];
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    @Override
    public String toString() {
        String s = getClass().getName();
        String message  =getLogMessage();

        StringBuilder sb = new StringBuilder(s).append("[ERRORCODE=")
                .append(getCode())
                .append("][")
                .append(message==null?"":message).append("]");

        return sb.toString();
    }
}
