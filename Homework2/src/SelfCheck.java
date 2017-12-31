//Mitheysh Asokan
//Homework 2 Problem 1

//Inputs = none
//Outputs = none

public class SelfCheck {
	public static void main(String[] args) {
		//Question 9 
		List.next.next = new ListNode(3, null);
		
		//Question 10
		ListNode temp = List;
		List = new ListNode(3, temp);
		
		//Question 11
		temp.next.next = List.next;
		List.next = temp;
		
		//Question 12
		ListNode List2 = list;
		List = List.next;
		List2.next = List2.next.next;
		List.next = null;
		
		//Question 13
		ListNode temp = List.next;
		List.next = List.next.next;
		temp.next = List;
		List = temp;
		
		//Question 14
		ListNode temp = List;
		List = temp.next.next;
		List.next = temp.next.next;
		temp.next.next = temp.next;
		temp.next = null;
		
		//Question 15
		temp.next.next = List.next.next;
		temp.next.next = temp;
		ListNode temp2 = temp.next.next;
		temp.next = List.next;
		List.next.next = null;
		List = temp2;
		
		//Question 16
		ListNode temp = List2;
		ListNode temp2 = List;
		List2 = List.next;
		List = temp.next.next;
		List.next = temp2;
		List.next.next = temp;
		List.next.next.next = null;
		List2.next = null;
		
		//Question 17
		ListNode temp = List;
		List = List.next.next.next;
		List.next = temp.next;
		ListNode List2 = temp.next.next;
		List2.next = temp;
		List.next.next = null;
		List2.next.next = null;
		
	}
	
}

































