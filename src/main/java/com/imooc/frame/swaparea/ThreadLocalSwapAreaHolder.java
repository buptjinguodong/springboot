
public class ThreadLocalSwapAreaHolder implements SwapAreaHolder {

	private ThreadLocal<SwapArea> holder = new ThreadLocal<SwapArea>();

	void setCurrentSwapArea(SwapArea swapArea) {
		holder.set(swapArea);
	}

	SwapArea getCurrentSwapArea(){
		return holder.get();
	}

	SwapArea removeCurrentSwapArea() {
		SwapArea swapArea = holder.get();

		holder.remove();

		return swapArea;
	}
}