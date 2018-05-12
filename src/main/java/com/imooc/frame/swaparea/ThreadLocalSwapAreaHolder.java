package com.imooc.frame.swaparea;

public class ThreadLocalSwapAreaHolder implements SwapAreaHolder {

	private ThreadLocal<SwapArea> holder = new ThreadLocal<SwapArea>();

	public void setCurrentSwapArea(SwapArea swapArea) {
		holder.set(swapArea);
	}

	public SwapArea getCurrentSwapArea(){
		return holder.get();
	}

	public SwapArea removeCurrentSwapArea() {
		SwapArea swapArea = holder.get();

		holder.remove();

		return swapArea;
	}
}