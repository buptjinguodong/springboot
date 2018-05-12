package com.imooc.frame.swaparea;

public interface SwapAreaHolder {

	void setCurrentSwapArea(SwapArea swapArea);

	SwapArea getCurrentSwapArea();

	SwapArea removeCurrentSwapArea();

}