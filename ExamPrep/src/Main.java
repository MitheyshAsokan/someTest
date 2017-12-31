
public class Main {
	public static void main(String[] args) {
		 int[] theArray = {1,2,3,4,5,6,7};
		 
		 for (int i : theArray) {
			System.out.println(i);
		 }
		 
		 mergeSort(theArray);
		 System.out.println();
		 
		 for (int i : theArray) {
			System.out.println(i);
		 }
		 System.out.println();
		 System.out.println(binarySearch(theArray, 3));
		 
	}
	
	
	public static int binarySearch(int[] array, int value) {
		return binarySearch(array, value, 0, array.length - 1);
	}
	
	public static int binarySearch(int[] array, int value, int start, int end) {
		
		int mid = (start + end) / 2;
		
		if(array[mid] == value) {
			return mid;
		}
		
		if(array[mid] > value && value >= array[start]) {
			end = mid - 1;
			return binarySearch(array, value, start, end);
		}
		
		if(array[mid] < value && value <= array[end]) {
			start = mid + 1;
			return binarySearch(array, value, start, end);
		}
		
		return -1;
	}
	
	
	public static void selecSort(int[] theArray) {
		for (int i = 0; i < theArray.length; i++) {
			
			for (int j = (i + 1); j < theArray.length; j++) {
				
				if(theArray[i] > theArray[j]) {
					int temp = theArray[i];
					theArray[i] = theArray[j];
					theArray[j] = temp;
				}
			}
			
		}
	}
	
	
	public static void inserSort(int[] theArray) {
		for(int i = 1; i < theArray.length; i++) {
			
			int j = i;
			while(j > 0 && theArray[j] < theArray[j - 1]) {
				int temp = theArray[j];
				theArray[j] = theArray[j - 1];
				theArray[j - 1] = temp;
				
				j--;
			}
		}
	}
	
	
	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1, new int[array.length]);
	}
	
	public static void mergeSort(int[] array, int leftStart, int rightEnd, int[] temp) {
		if(leftStart >= rightEnd) {
			return;
		}
		
		int middlePoint = (rightEnd + leftStart) / 2;
		mergeSort(array, leftStart, middlePoint, temp);
		mergeSort(array, middlePoint + 1, rightEnd, temp);
		mergeHalves(array, leftStart, rightEnd, temp);
	}
	
	public static void mergeHalves(int[] array, int leftStart, int rightEnd, int[] temp) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		
		int size = (rightEnd - leftStart) + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			
			index++;
		}
		
		System.arraycopy(array, left, temp, index, (leftEnd - left) + 1);
		System.arraycopy(array, right, temp, index, (rightEnd - right) + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
}





















