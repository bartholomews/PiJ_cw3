
public class LinkedList implements List {
	private Node head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}

	public ReturnObject get(int index) {
		if(isEmpty()) {
			ReturnObject wrap = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
			return wrap;
		} else if(index<0 || index>=size()) {
			ReturnObject wrap = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return wrap;
		} else {
			Node nodeAtIndex = head;
			for(int i=0; i<index; i++) {
				nodeAtIndex = nodeAtIndex.getNext();
			}	
			ReturnObject wrap = new ReturnObjectImpl(nodeAtIndex.getValue(), ErrorMessage.NO_ERROR);
			return wrap;	
		}
	}
	
	public ReturnObject remove(int index) {	// TO BE IMPLEMENTED
		return null;
	}
	
	public ReturnObject add(int index, Object item) {	// TO BE FIXED
		if(item==null) {
			ReturnObject wrap = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
			return wrap;
		} else if(index<0 || index>=size()) {
			ReturnObject wrap = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return wrap;
		} else {
			size++;
			ReturnObject wrap = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
			Node newNode = new Node(item);
			if(index==0) {
				newNode.setNext(head);
				head = newNode;
			} else {
				Node previous = head;
				for(int i=1; i<index; i++) {
					previous = previous.getNext();
				}
				newNode.setNext(previous.getNext());
				previous.setNext(newNode);
			}
			return wrap;	
		}					
	}
	
	public ReturnObject add(Object item) {
		if(item==null) {
			ReturnObject wrap = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
			return wrap;
		} else {
			size++;
			ReturnObject wrap = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
			Node newNode = new Node(item);
			if(isEmpty()) {
				head = newNode;
			} else {
				Node lastNode = head;
				while(lastNode.getNext()!=null) {
					lastNode = lastNode.getNext();
				}
				lastNode.setNext(newNode);
			}
			return wrap;
		}
	}
	
	public void printList() {
		if(isEmpty()) {
			System.out.println("The list is empty");
		} else {
			int n=0;
			Node aux = head;
			System.out.println("index " + n + ": " + aux.getValue());
			while(aux.getNext()!=null) {
				aux = aux.getNext();
				n++;
				System.out.println("index " + n + ": " + aux.getValue());
			}
		}
	
	}

}
	
	