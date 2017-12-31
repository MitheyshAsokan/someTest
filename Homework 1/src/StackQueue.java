//Mitheysh Asokan 	
//Homework 1
//2017/Oct/1

//No inputs or outputs

//This class privides the user a set of methods to work with stacks and queues.



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
	
	public static Stack<Integer> copyStack(Stack<Integer> oStack){
		
		Stack<Integer> copyStack = new Stack<>();
		Queue<Integer> tempQue = new LinkedList<>();
		
		//from stack to queue
		while(!(oStack.isEmpty())) {
			tempQue.add(oStack.pop());
		}
		//back to stack from que, but now you have a reverse que.
		while(!(tempQue.isEmpty())) {
			oStack.push(tempQue.remove());
		}
		
		//push the reverse into the temp, while pushing the peek of the 
		//original into the copyStack.
		while(!(oStack.isEmpty())) {
			copyStack.push(oStack.peek());
			tempQue.add(oStack.pop());
		}
		
		//restore the original stack 
		while(!(tempQue.isEmpty())) {
			oStack.push(tempQue.remove());
		}
		
		//return the copy. ;)
		return copyStack;
	}
	
	
	public static void rearrange(Queue<Integer> realQue) {
		Stack<Integer> tempStack = new Stack<>();
		int size = realQue.size();
		
		for(int i = 0; i < size; i++) {
			Integer someVal = realQue.remove();
			
			if((someVal.intValue() % 2) != 0) {
				tempStack.push(someVal);
			}else {
				realQue.add(someVal);
			}
		}
		
		while(!(tempStack.isEmpty())) {
			realQue.add(tempStack.pop());
		}
	}
	
	public static void expunge(Stack<Integer> theStack) {
		
		Stack<Integer> tempStack = new Stack<Integer>();
		tempStack.push(theStack.pop());
		
		while(!(theStack.isEmpty())) {
			
			if(theStack.peek().intValue() >= tempStack.peek().intValue()) {
				tempStack.push(theStack.pop());
			}else {
				theStack.pop();
			}
		}
		
		while(!(tempStack.isEmpty())) {
			theStack.push(tempStack.pop());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
