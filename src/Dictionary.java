import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
	
	class Node<K, V>{
		K key;
		V value;
		
		Node<K, V> next;
		
		public Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}

	int size;
	int bucketSize;
	
	List<Node<K, V>> bucket;
	
	public Dictionary() {
		bucketSize = 10;
		bucket = new ArrayList<>();
		
		for(int i = 0; i < bucketSize; i++)
			bucket.add(null);
	}
	
	int getBucketIndex(K key) {
		return key.hashCode() % bucketSize;
	}
	
	
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		Node<K, V> head = bucket.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key))
				return head.value;
			
			head = head.next;
		}
		
		return null;
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		
		Node<K, V> head = bucket.get(bucketIndex);
		
		Node<K, V> pre = null;
		while(head != null) {
			if(head.key.equals(key))
				break;
			
			pre = head;
			head = head.next;
		}
		
		if(head == null)
			return null;
		
		size--;
		if(pre != null)
			pre.next = head.next;
		else
			bucket.set(bucketIndex, head.next);
				
		return head.value;
	}
	
	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		Node<K, V> head = bucket.get(bucketIndex);
		
		Node<K, V> cur = head;
		while(cur != null) {
			if(cur.key.equals(key)) {
				cur.value = value;
				return;
			}
		}
		
		size++;
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		bucket.set(bucketIndex, newNode);
		
		if(size / (bucketSize * 1.0) > 0.7) {
			List<Node<K, V>> temp = bucket;
			
			bucket = new ArrayList<>();
			for(int i = 0; i < bucketSize; i++) {
				bucket.add(null);
			}
			
			for(Node<K, V> hn : temp) {
				while(hn != null) {
					put(hn.key, hn.value);
					hn = hn.next;
				}
			}
		}
	}
}
