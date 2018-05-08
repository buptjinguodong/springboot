package com.imooc.demo.utils;

public class AppBeanUtils{
	/** The Constant logger. */
	private static final Log  logger = LogFactory.getLog(AppBeanUtils.class);

	public static String objectToString(Object bean){
		return ToStringBuilder.reflectionToString(bean);
	}

	public static String objectToXmlString(Object bean){
		// org.apache.commons.lang.builder.ToStringABuilder/ToStringStyle
		return ToStringBuilder.reflectionToString(bean, ToStringStyle.MULTI_LINE_STYLE);
	}


	final static String PATTERN_PRODCODE = "s[0-9,a-z]{2}";

	/**
	 * com.ccb.s31.Customer
	 * return s31
	 */
	public static String getProdCode(Object bean){
		String packageName = ClassUtils.getPackageName(bean, "");
		String[] packages = packageName.split("\\.");
		for(int i=0; i<packages.length; i++){
			String subPkgName = packages[i];
			if(subPkgName.length() == 3
				&& subPkgName.matches(PATTERN_PRODCODE)) {
				return subPkgName;
			}
		}
		return null;
	}


	public static <T> T copyProperties(Object source, Class<T> targetClass)
		throws CommonRuntimeException{
		try{
			T targetObj = targetClass.newInstance();
			copyProperties(source, targetObj);
			return targetObj;
		} catch(Exception e){
			looger.error(source.getClass().getCanonicalName()
				+ " cannot transform to " + targetClass.getCanonicalName()
				+ " : " + e.getMessage());
			throw new CommonRuntimeException("EDBF300500AA", e, "对象属性转换异常！");
		}

	}

	public static void copyProperties(Object source, Object target){
		BeanUtils.copyProperties(source, target);
	}

	public static String getWeblogicServerName(){
		String serverName = System.getProperty("weblogic.Name");
		// org.apache.commons.lang3.StringUtils
		return StringUtils.substring(serverName, -3);
	}
}




