package tree;

public class tree {
	node root;

	public void insertNode(int data) {
		node toInsert=new node(data);
		if(this.root==null) {
			this.root= toInsert;
			return;
		}
		node tmp=root;
		while(tmp!=null) {
			if(tmp.data>data) {
				if(tmp.left==null) {
					tmp.left=toInsert;
					return;
				}
				tmp=tmp.left;
			}
			else {
				if(tmp.right==null) {
					tmp.right=toInsert;
					return;
				}
				tmp=tmp.right;
			}
		}
	}
	
	public String inOrder(node node) {
		String toReturn="" ;
		if(node==null)
			return toReturn;
		toReturn=toReturn + this.inOrder(node.left);
		toReturn+= "" + node.data;
		toReturn+=this.inOrder(node.right);
		return toReturn;
	}
	public String postOrder(node node) {
		String toReturn="" ;
		if(node==null)
			return toReturn;
		toReturn=toReturn + this.postOrder(node.left);
		toReturn+=this.postOrder(node.right);
		toReturn+= "" + node.data;
		return toReturn;
	}
	public String preOrder(node node) {
		String toReturn="" ;
		if(node==null)
			return toReturn;
		toReturn+= "" + node.data;
		toReturn=toReturn + this.preOrder(node.left);
		toReturn+=this.preOrder(node.right);
		return toReturn;
	}
	
	public node deleteNode(node root,int key) {
		if(root==null)
			return root;
		if(root.data<key)
			root.right=deleteNode(root.right,key);
		if(root.data>key)
			root.left=deleteNode(root.left,key);
		
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			
			root.data=findSuccesor(root).data;
			root.right=deleteNode(root.right,root.data);
		}
		
		return root;
	}
	

	public node findSuccesor(node toSearch) {
		node toReturn=toSearch;
		if(toReturn.right!=null) {
			toReturn=toReturn.right;
			while(toReturn.left!=null) {
				toReturn=toReturn.left;				
			}
		}
		return toReturn;
	}
	
	public node searchNode(int data) {
		node toReturn=root;
		while(toReturn!=null) {
			if(toReturn.data>data)
				toReturn=root.left;
			else if(toReturn.data<data)
				toReturn=toReturn.right;
			else
				return  toReturn;
		}
		return null;
	}

}
