package com.imooc.frame.swaparea;

public interface SwapAreaManager {

	public SwapArea buildNewSwapArea();

	public SwapArea getCurrentSwapArea();

	public SwapArea releaseCurrentSwapArea();
}