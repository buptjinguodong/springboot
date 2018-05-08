public class DefaultSwapAreaManager implements SwapAreaManager {
	private SwapAreaHolder swapAreaHolder;

	public DefaultSwapAreaManager(SwapAreaHolder swapAreaHolder) {
		this.swapAreaHolder = swapAreaHolder;
	}

	public SwapArea getCurrentSwapArea() {
		return this.swapAreaHolder.getCurrentSwapArea();
	}

	public SwapArea releaseCurrentSwapArea() {
		return this.swapAreaHolder.removeCurrentSwapArea();
	}
}