import java.util.Iterator;
import java.util.LinkedList;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList myList = new LinkedList();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		myList.add("6");
		
		Iterator myIter = myList.iterator();
		while(myIter.hasNext())
			System.out.println(myIter.next());
	}
}