public interface SwapAreaManager {
	SwapArea buildNewSwapArea();

	SwapArea getCurrentSwapArea();

	SwapArea releaseCurrentSwapArea();
}