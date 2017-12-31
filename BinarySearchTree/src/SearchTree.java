
public class SearchTree {
	private TreeNode root;
	
	
	public SearchTree(int data) {
		root = new TreeNode(data);
	}
	
	public void addItem(int data) {
		addItem(data, root);
	}
	
	private void addItem(int data, TreeNode Troot) {
		
		if(data >= Troot.data) {
			if(Troot.right == null) {
				Troot.right = new TreeNode(data);
			}else {
				addItem(data, Troot.right);
			}
			
		} else if(data < Troot.data) {
			if(Troot.left == null) {
				Troot.left = new TreeNode(data);
			}else {
				addItem(data, Troot.left);
			}
		}
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(TreeNode root) {
		
		
		if(root.right != null) {
			printTree(root.right);
		}
		
		System.out.print(root.data + " ");
		
		if(root.left != null) {
			printTree(root.left);
		}
	}
	
	public boolean contains(int data) {
		return contains(data, root);
	}
	
	private boolean contains(int data, TreeNode root) {
		if(data == root.data) {
			return true;
		}
		
		if(data > root.data && root.right != null) {
			return contains(data, root.right);
		}else if(data < root.data && root.left != null) {
			return contains(data, root.left);
		}
		
		return false;
	}
}






















