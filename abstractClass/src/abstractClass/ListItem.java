package abstractClass;

public abstract class ListItem {
	protected ListItem rightItem = null;
	protected ListItem leftItem = null;
	
	protected Object contentOfList;

	public ListItem(Object contentOfList) {
		this.contentOfList = contentOfList;
	}
	
	abstract ListItem next();
	abstract ListItem previous();
	abstract ListItem setNext(ListItem newItem);
	abstract ListItem setPrevious(ListItem newItem);
	abstract int comepareTo(ListItem someItem);

	public Object getContentOfList() {
		return contentOfList;
	}

	public void setContentOfList(Object contentOfList) {
		this.contentOfList = contentOfList;
	}
}
