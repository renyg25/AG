import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SmartQueue {
	
	class DLinkedList{
		public char key;
		
		DLinkedList pre;
		DLinkedList next;
		
		public DLinkedList(char key) {
			this.key = key;
		}
	}
	
	DLinkedList head = new DLinkedList(' ');
	DLinkedList tail = new DLinkedList(' ');
	
	HashMap<Character, DLinkedList> dMap = new HashMap<>();
	HashMap<Character, Integer> map = new HashMap<>();
	
	public SmartQueue() {
		head.next = tail;
		tail.pre = head;
	}
	
	public void push(char key, int val) {
		if(map.containsKey(key)){
			move2Head(dMap.get(key));	
		}else		
			insert(key);
		map.put(key, val);		
	}
	
	void insert(char key) {
		DLinkedList node = new DLinkedList(key);
		head.next.pre = node;
		node.next = head.next;
		node.pre = head;
		head.next = node;
		
		dMap.put(key, node);
	}
	
	void remove(DLinkedList node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	
	void move2Head(DLinkedList node) {
		remove(node);
		head.next.pre = node;
		node.next = head.next;
		node.pre = head;
		head.next = node;
	}
	
	void print() {
		DLinkedList cur = head.next;
		while(cur != null && cur != tail) {
			System.out.println(cur.key + " " + map.get(cur.key));
			cur = cur.next;
		}
	}
	
	
//	HashMap<Character, Integer> map = new HashMap<>();
//	Queue<Character> que = new LinkedList<>();
//	
//	public void push(char key, int value) {
//		if(!map.containsKey(key)) {
//			que.offer(key);			
//		}else {
//			Queue<Character> tq = new LinkedList<>();
//			while(que.peek() != key) {
//				tq.offer(que.poll());
//			}
//			
//			que.addAll(tq);
//		}
//		
//		map.put(key, value);
//	}
//	
//	public void print() {
//		for(char ch : que) {
//			System.out.println(ch + " " + map.get(ch));
//		}
//	}
}
