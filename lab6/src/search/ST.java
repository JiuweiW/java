package search;

import java.util.Iterator;
import java.util.Queue;
import lib.*;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key>{
	private static final int INIT_SIZE = 8;
	
	private Value[] vals;
	private Key[] keys;
	private int N = 0;
	
	public ST() {
		keys = (Key[]) new Object[INIT_SIZE];
		vals = (Value[])  new Object[INIT_SIZE];
	}
	
	// return the number of key-value pairs in the symbol table
	public int size() {
		return N;
	}
	
	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// resize the parallel arrays to the given capacity
	private void resize(int capacity) {
		Key[] tempk = (Key[]) new Object[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i=0; i<N; i++)
			tempk[i] = keys[i];
		for (int i=0; i<N; i++)
			tempv[i] = vals[i];
		keys = tempk;
		vals = tempv;
	}
	
	// insert the key-value pair into the symbol table
	public void put(Key key, Value val) {
		// to dealwith duplicates
		delete(key);
		
		// double size of arrays if necessary
		if (N >= vals.length) resize(2*N);
		
		// add new key and value at the end of array
		vals[N] = val;
		keys[N] = key;
		N++;
	}
	
	public Value get(Key key) {
		for (int i=0; i<N; i++){
			if (keys[i].equals(key))
				return vals[i];
		}
		return null;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i=0; i<N; i++)
			queue.enqueue(keys[i]);
		return queue;
	}
	
	public void delete(Key key) {
		for (int i=0; i<N; i++) {
			if (key.equals(keys[i])){
				keys[i] = keys[N-1];
				vals[i] = vals[N-1];
				keys[N-1] = null;
				vals[N-1] = null;
				N--;
				if (N>0 && N == keys.length/4)
					resize (keys.length/2);
				return;
			}
		}
	}
	
	public boolean contains(Key key) {
		return false;
	}

	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		for (int i=0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
