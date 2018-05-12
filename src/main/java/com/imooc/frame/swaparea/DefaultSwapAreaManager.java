package com.imooc.frame.swaparea;

public class DefaultSwapAreaManager implements SwapAreaManager {
	private SwapAreaHolder swapAreaHolder;

	public DefaultSwapAreaManager(SwapAreaHolder swapAreaHolder) {
		this.swapAreaHolder = swapAreaHolder;
	}

	@Override
	public SwapArea buildNewSwapArea() {
		if (swapAreaHolder.getCurrentSwapArea() == null) {
			swapAreaHolder.setCurrentSwapArea(new DefaultSwapArea());
		}

		return swapAreaHolder.getCurrentSwapArea();
	}

	public SwapArea getCurrentSwapArea() {
		return this.swapAreaHolder.getCurrentSwapArea();
	}

	public SwapArea releaseCurrentSwapArea() {
		return this.swapAreaHolder.removeCurrentSwapArea();
	}
}