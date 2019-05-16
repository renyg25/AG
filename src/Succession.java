import java.util.List;

public interface Succession {
	void birth(String parent, String name);
	void death(String name);
	List<String> getOrderOfSuccession();
}
