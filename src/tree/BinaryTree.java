package tree;

import entidades.Node;

public class BinaryTree {
	private Node root;
	private Node actual;
	
	public BinaryTree(){
		root = null;
	}
	
	//M�todo de inserci�n
	public void addRoot(Node e){
		if(isEmpty()) {
			root = e;
		}else{
			throw new RuntimeException("Root has already a value");
		}
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void addTo(int idParent, Node e){
		inOrder(idParent, root);
		Node parent = actual;
		
		if(!parent.hasLeft()){
			parent.setLeft(e);
			e.setPred(parent);
			return;
		}
		if(!parent.hasRight()){
			parent.setRight(e);
			e.setPred(parent);
			return;
		}
	}
	
	public void inOrder(int id, Node e){
        if(e != null){
            this.inOrder(id, e.getLeft());
            if(e.getId() == id)
                this.actual = e;
            this.inOrder(id, e.getRight());
        }
    }
	
	public Node searchId(int id, Node start){ //start. nodo que pasamos de comienzo
		
		if(isEmpty()) throw new RuntimeException ("This tree is empty"); //No est� vacio CORRECTO
		if(start.getId() == id) //CORRECTO
			return start; // CORRECTO
		else if(start.hasLeft() && start.getId() != id) // If the actual node has a different id look the left child
			return searchId(id, start.getLeft());
		else if(start.hasRight() && start.getId() != id) // If the actual node has a different id look the right child
			return searchId(id, start.getRight());
		
		return start;
	}
	
	public Node getRoot(){
		return root;
	}
	
	 public void preOrder(Node e){
	        if(e != null){
	        	System.out.println(e.toString());
	            this.preOrder(e.getLeft());
	            this.preOrder(e.getRight());
	        }
	    }
	
//	public void nextNode(boolean decision){
//		Node actual = new Node(root);
//		if(decision){
//			actual = actual.getIzq();
//		}else{
//			actual = actual.getDer();
//		}
//	}
	
	
	
}

