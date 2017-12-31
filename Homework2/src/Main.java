
public class Main {
	public static void main(String[] args) {
		LinkedIntList list = new LinkedIntList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(10);
		
		LinkedIntList list2 = list.removeEvens();
		
		System.out.println(list.toString());
		System.out.println(list2.toString());
	}

}














