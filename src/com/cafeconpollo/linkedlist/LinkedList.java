package com.cafeconpollo.linkedlist;

public class LinkedList {
	private Node list;
	private int count;
	private DoAction doCustomStuff;
	
	public LinkedList(DoAction action) {
		list = null;
		doCustomStuff = action;
	}
	
	public void addToFront(Object val) {
	    list = new Node(val,list);
	    count++;
	}

	public int getCount() {
		return count;
	}
	
	public void traverseList() {
		Node ptr = list;
		while (ptr != null) {
			if (ptr.next != null)
				doCustomStuff.doAction(ptr.data, false);
			else
				doCustomStuff.doAction(ptr.data, true);
			ptr = ptr.next;
		}
	}

}
