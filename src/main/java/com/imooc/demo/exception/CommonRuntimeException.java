//package com.imooc.demo.exception
//
//import com.sun.org.apache.xml.internal.security.utils.I18n;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.context.NoSuchMessageException;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//import java.util.Locale;
//
//public class CommonRuntimeException extends RuntimeException{
//
//	private static final long serialVersionUID = 63266450420472654286L;
//
//	private static final Log log = LogFactory
//			.getLog(CommonRuntimeException.class);
//
//	public static final String log001 = "code={0}locale={1}";
//
//	private String code;
//	private Object[] params;
//	private List<Locale> locales;
//
//	public CommonRuntimeException(String code, Throwable e,
//			List<Locale> locales, Object... params){
//		super(e);
//		this.code = code;
//		this.params = params;
//		this.locales = locales;
//	}
//
//	public CommonRuntimeException(String code, Throwable e, Object... params){
//		this(code, e, null, params);
//	}
//
//	public CommonRuntimeException(String code, Object... params){
//		this(code, null, params);
//	}
//
//	public CommonRuntimeException(Throwable e){
//		this(null, e);
//	}
//
//	public CommonRuntimeException(){
//
//	}
//
//	@Override
//	public String getMessage(){
//		return assembleMessage(getLogMessage());
//	}
//
//	@Override
//	public String getLocalizedMessage() {
//		if(CollectionUtils.isEmpty(locales)) {
//			return getLocalizedExceptionMessage(CommunicationStaticsParam.communicationLocal);
//		}
//
//		String exceptionMessage = null;
//		for (Locale locale : locales) {
//			if (locale != null) {
//				exceptionMessage = getLocalizedExceptionMessage(locale);
//				if (StringUtils.hasText(exceptionMessage)) {
//					return assembleMessage(exceptionMessage);
//				}
//			}
//		}
//
//		return getMessage;
//	}
//
//	public String getLocalizedExceptionMessage(Locale locale) {
//		if (!StringUtils.hasText(getCode())) {
//			return null;
//		}
//
//		String exceptionMessage = null;
//		try {
//			exceptionMessage = I18n.getMessage(getCode(), getParameters(),
//					locale);
//		} catch (NoSuchMessageException e){
//			log.error("log001", e, getCode(), locale);
//		}
//	}
//
//	private String getLogMessage(){
//		String message = LogExceptionMessage.getMessage(getCode());
//		if ((message != null)&&(params != null) && (params.length > 0)) {
//			MessageFormat mf = new MessageFormat(message);
//			message = mf.format(params);
//		}
//
//		return StringUtils.hasText(message) ? message
//				: "";
//	}
//
//	public int getMessageLength() {
//		if (!StringUtils.hasText(getCode())) {
//			return 0;
//		}
//
//		if (null != getLocalizedMessage()) {
//			return getLocalizedMessage().length();
//		} else {
//			return 0;
//		}
//	}
//
//	public int getMessageBytes() {
//		if (!StringUtils.hasText(getCode())) {
//			return 0;
//		}
//
//		if (null != getLocalizedMessage()) {
//			return getLocalizedMessage().getBytes().length;
//		} else {
//			return 0;
//		}
//	}
//
//	private String assembleMessage(String exceptionMessage) {
//		return new StringBuilder("[ERRORCODE=")
//				.append(getCode())
//				.append("] [")
//				.append(StringUtils.hasText(exceptionMessage) ? exceptionMessage
//						: "").append("]").toString();
//	}
//
//	@Override
//	public String getCode(){
//		return code;
//	}
//	@Override
//	public Object[] getParameters() {
//		return params;
//	}
//
//	public List<Locale> getLocales() {
//		return locales;
//	}
//
//	public void setLocales(List<Locale> locales) {
//		this.locales = locales;
//	}
//
//	@Override
//	public String toString() {
//		String s = getClass().getName();
//		String message = getLogMessage();
//
//		StringBuilder sb = new StringBuilder(s).append("[ERRORCODE=")
//							.append(getCode())
//							.append("] [")
//							.append(message==null?"":message).append("]");
//		return sb.toString();
//	}
//}