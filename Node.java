package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() throws CloneNotSupportedException {
		// Enter your code here
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
//		for(Integer number : data) {
//			if(!isTerminal()) {
//				int index = number/2;
//				for(int i=1 ; i<= index ; i++) {
//					if(!set.contains(index)) {
//						set.add(i);
//					}
//				}
//				
//			}
//		}
		for(int  i =0 ; i< this.data.size(); i++) {
			if(!isTerminal()) {
				int number = data.get(i) / 2;
				for(int j= 1; j<= number; j++) {
					int x= this.data.get(i) - j;
					list.add(x);
					list.add(i);
					Node node = new Node();
					node.clone();
					node.data.remove(i);
					node.addAll(list);
					
				}
			}
		}
		return null;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
//		<=2 : leaf
		for(int i = 0; i< data.size(); i++){
			if(data.get(i) >2) {
				return false;
			}
		}
		
		return true;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}
	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}
}
