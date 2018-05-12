package com.imooc.demo.utils;

import com.imooc.frame.swaparea.SwapArea;
import com.imooc.frame.swaparea.SwapAreaUtils;

public class DataBusUtils {

	private static SwapArea swapArea = SwapAreaUtils.buildNewSwapArea();

	public static Object getValue(String key) {
		return swapArea.getValue(key);
	}

	public static void setValue(String key, Object obj){
		swapArea.setValue(key, obj);
	}
}