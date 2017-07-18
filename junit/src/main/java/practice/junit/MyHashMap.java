package practice.junit;

import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {

	private int size=0;
	private final int limit;
	transient Node<K, V>[] table;

	public MyHashMap(int limit) {
		this.limit = limit;
		table = (Node<K, V>[]) new Node[limit];
	}

	public int size() {
		return size;
	}

	private int hash(K key) {
		return key.hashCode() % limit;
	}

	public V put(K key, V value) {
		if (null == key)
			return null;
		int hash = hash(key);
		Node<K, V> newNode = new Node<K, V>(hash, key, value, null);
		if (null == table[hash]) {
			table[hash] = newNode;
			size++;
			return value;
		}
		Node<K, V> current = table[hash];//current can't be null, already handled above
		do{
			if (current.key.equals(key)) {
				return current.setValue(value);
			}
			current = current.next;
		} while (current.next!=null) ;
		current.next = newNode;
		size++;
		return value;
	}

	public V get(K key) {
		int hash = hash(key);
		Node<K, V> current = table[hash];
		while (null != current && !current.key.equals(key)) {
			current = current.next;
		}
		if (current == null)
			return null;
		return current.value;
	}


	private static class Node<K, V> {
		private final int hash;
		private final K key;
		private V value;
		private Node<K, V> next;

		public Node(int hash, K key, V value, Node<K, V> next) {
			super();
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final String toString() {
			return key + "=" + value;
		}

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
				if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<String, String>(8);
		map.put("TEST", "TEST VALUE");
		map.put("TEST", "TEST VALUE2");
		map.put("TEST1", "TEST VALUE3");
		System.out.println(map.get("TEST3"));
		System.out.println(map.get("TEST"));
		System.out.println(map.get("TEST1"));
		System.out.println(map.size());
	}
}
