package abstractClass;

public class Node extends ListItem{

	public Node(Object contentOfList) {
		super(contentOfList);
	}

	@Override
	ListItem next() {
		return this.rightItem;
	}

	@Override
	ListItem previous() {
		// TODO Auto-generated method stub
		return this.leftItem;
	}

	@Override
	ListItem setNext(ListItem newItem) {
		// TODO Auto-generated method stub
		this.rightItem = newItem;
		return this.rightItem;
	}

	@Override
	ListItem setPrevious(ListItem newItem) {
		// TODO Auto-generated method stub
		this.leftItem = newItem;
		return this.leftItem;
	}

	@Override
	int comepareTo(ListItem someItem) {
		// TODO Auto-generated method stub
		if(someItem == null) {
			return -1;
		}else {
			return ((String) super.getContentOfList()).compareTo((String) someItem.getContentOfList());
		}
	}

}



















