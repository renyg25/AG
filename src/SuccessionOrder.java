import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuccessionOrder implements Succession{
	
	Map<String, Node> map;
	Node root;
	
	public SuccessionOrder() {
		// TODO Auto-generated constructor stub
		map = new HashMap<>();
		root = new Node("King", false);
		map.put(root.name, root);
	}

	@Override
	public void birth(String parent, String name) {
		// TODO Auto-generated method stub
		Node node = new Node(name, false);
		map.put(name, node);
		map.get(parent).children.add(node);
	}

	@Override
	public void death(String name) {
		// TODO Auto-generated method stub
		if (map.containsKey(name)) {
			map.get(name).isDead = true;
		}		
	}

	@Override
	public List<String> getOrderOfSuccession() {
		// TODO Auto-generated method stub
		List<String> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}
	
	void dfs(Node node, List<String> res) {
		if(node == null)
			return;
		
		if (!node.isDead) {
			res.add(node.name);
		}
		
		for (Node n : node.children) {
			dfs(n, res);
		}
	}

	class Node{
		String name;
		List<Node> children;
		boolean isDead;
		
		public Node(String name, boolean isDead) {
			this.name = name;
			this.isDead = isDead;
			children = new ArrayList<>();
		}
	}
}
