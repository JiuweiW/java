package lab3;

public class Counter {
	private final String name;
	private int count;
	
	public Counter(String id) {
		name = id;
	}
	
	public void increment() {
		count++;
	}
	
	public int tally() {
		return count;
	}
	
	public String toString(){
		return count + " " + name;
	}
	
	public int compareTo(Counter that) {
		if (this.count < that.count)
			return -1;
		else if (this.count > that.count)
			return +1;
		else
			return 0;
	}
}
