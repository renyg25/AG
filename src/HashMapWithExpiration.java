import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapWithExpiration implements MapWithExpiration{
	
	private int expiration;
	private Map<Integer, TaskNode> map;
	
	public HashMapWithExpiration(int expiration) {
		this.expiration = expiration;
		map = new HashMap<>();
	}

	@Override
	public void put(int key, int value) {
		map.put(key, new TaskNode(key, value));
	}

	@Override
	public int get(int key) {
		if (map.containsKey(key) && isExpired(map.get(key))) {
			map.remove(key);
		}
		
		return map.containsKey(key) ? map.get(key).val : -1;
	}

	@Override
	public void clean() {
		Set<Integer> set = new HashSet<>(map.keySet());
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			if (isExpired(map.get(key))) {
				map.remove(key);
			}
		}
	}
	
	boolean isExpired(TaskNode node) {
		return System.currentTimeMillis() - node.timestamp >= expiration;
	}
	

	class TaskNode{
		int key;
		int val;
		long timestamp;
		
		public TaskNode(int key, int val) {
			this.key = key;
			this.val = val;
			timestamp = System.currentTimeMillis();
		}
	}
}
