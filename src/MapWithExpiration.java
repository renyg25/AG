
public interface MapWithExpiration {
	void put(int key, int value);
	int get(int key);
	void clean();
}
