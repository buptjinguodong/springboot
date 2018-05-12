package com.imooc.frame.swaparea;

public class SwapAreaUtils implements SwapAreaStatics {

	private static SwapAreaManager swapAreaManager = new DefaultSwapAreaManager(new ThreadLocalSwapAreaHolder());

	public static SwapArea buildNewSwapArea() {
		if (swapAreaManager.getCurrentSwapArea() == null) {
			return swapAreaManager.buildNewSwapArea();
		}
		return swapAreaManager.getCurrentSwapArea();
	}

	public static SwapArea getCurrentSwapArea() {
		if (swapAreaManager != null) {
			return swapAreaManager.getCurrentSwapArea();
		}
		return null;
	}

	public static SwapArea releaseCurrentSwapArea() {
		if (swapAreaManager != null) {
			return swapAreaManager.releaseCurrentSwapArea();
		}
		return null;
	}

	public static Object getValue(String path) {
		SwapArea currentSwapArea = getCurrentSwapArea();
		if (currentSwapArea == null) {
			return null;
		}
		return currentSwapArea.getValue(path);
	}

	public static <T> T getValue(String path, Class<T> clazz) {
		SwapArea currentSwapArea = getCurrentSwapArea();
		if (currentSwapArea == null) {
			return null;
		}
		return (T) currentSwapArea.getValue(path, clazz);
	}

	public static void setValue(String path, Object value) {
		SwapArea currentSwapArea = getCurrentSwapArea();
		if (currentSwapArea != null) {
			currentSwapArea.setValue(path, value);
		}
	}

}