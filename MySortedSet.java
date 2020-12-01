package cd.tij.demo.containers;
import java.util.*;

class MySortedSet<T> extends LinkedList<T>{
	int compare(T t1,T t2) {
		int deff = t1.hashCode()-t2.hashCode();
		return deff<0?-1:(deff==0?0:1);
	}
	public boolean add(T t) {
		if(!this.contains(t)) {
//			Iterator<T> iterator = this.iterator();
			int index =0;
//			while(iterator.hasNext()) {
//				if(compare(iterator.next(),t)<1) 
//					index++;
//			}
			for(T s:this){
				if(compare(s,t)<1){
					index++;
				}
			}
			add(index,t);
			return true;
		}
		return false;
	}
}

public class exercise_17_10 {
public static void main(String[] args) {
	Random rand = new Random();
	MySortedSet<Integer> integerss = new MySortedSet();
	for(int i =0;i<20;i++) {
		integerss.add(rand.nextInt(30));
	}
	System.out.print(integerss);
	
  }
} 
