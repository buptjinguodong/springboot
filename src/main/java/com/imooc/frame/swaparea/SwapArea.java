
public interface SwapArea extends Map{

	Object getValue(String path);

	<T> T getValue(String path, Class<T> clazz);

	void setValue(String path, Object value);

	boolean containsPath(String path);

}