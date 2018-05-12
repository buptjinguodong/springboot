package com.imooc.frame.swaparea;

import java.util.HashMap;

public class DefaultSwapArea extends HashMap implements SwapArea {
	private static final long serialVersionUID = 123L;

	@Override
	public Object getValue(String path) {
		return this.get(path);
	}

	@Override
	public <T> T getValue(String path, Class<T> clazz) {
		return (T) this.get(path);
	}

	@Override
	public void setValue(String path, Object value) {
		this.put(path, value);
	}

	@Override
	public boolean containsPath(String path) {
		try {
			Object obj = getValue(path);
			if (obj == null) {
				return false;
			}
		} catch (Throwable t) {
			return false;
		}
		return true;
	}

}