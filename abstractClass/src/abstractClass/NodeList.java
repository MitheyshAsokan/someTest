package abstractClass;

public interface NodeList {
	ListItem getRoot();
	boolean addListItem(ListItem newItem);
	boolean removeListItem(ListItem someListItem);
	void traverseList(ListItem head);
}
