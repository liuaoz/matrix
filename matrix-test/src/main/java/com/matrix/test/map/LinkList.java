package com.matrix.test.map;

/**
 * 链表
 * 
 * @author matrix
 *
 * @date 2015年11月11日
 * 
 */
public class LinkList {

	private Node first;

	private Node last;

	private int size;

	public void add(Object o) {
		Node node = new Node();
		if (this.first == null) {
			node.setPre(null);
			node.setNext(null);
			node.setData(o);
			this.first = node;
			this.last = node;
		} else {
			node.setPre(last);
			node.setData(o);
			node.setNext(null);

			last.setNext(node);
			last = node;

			// Node old = last;
			// old.setNext(node);
			// this.setLast(node);
			// last.setData(o);
			// last.setPre(old.getNext());
			// last.setNext(null);
		}
		this.size++;
	}

	public void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Node getNode(int index){
		Node tmp = null;
		if(first != null){
			tmp = first;
			for(int i = 0;i<index;i++){
				tmp = tmp.next;
			}
			return tmp;
		}
		return null;
	}
	
	public Object get(int index) {
		rangeCheck(index);
//		int i = 0;
//		for (Node node = first; node.next != null; node = node.next) {
//			if (i == index) {
//				return node.getData();
//			}
//			i++;
//		}
//		return null;
		
		Node tmp = getNode(index);
		if(tmp != null){
			return tmp.getData();
		}
		
		return null;
	}

	public boolean remove(int index) {
		rangeCheck(index);
		Node tmp = getNode(index);
		
		if(tmp != null){
			Node up = tmp.getPre();
			Node down = tmp.getNext();
			up.setNext(down);
			down.setPre(up);
			size--;
			return true;
		}
		return false;
	}

	public boolean unlink(Node node) {

		return false;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		LinkList link = new LinkList();
		link.add("aa");
		link.add("bb");
		link.add("cc");
		System.out.println(link.get(3));

	}

	public LinkList() {
	}

	public LinkList(Node first, Node last, int size) {
		super();
		this.first = first;
		this.last = last;
		this.size = size;
	}

	class Node {

		private Node pre;
		private Node next;
		private Object obj;

		public Node() {
		}

		public Node(Node pre, Node next, Object obj) {
			super();
			this.pre = pre;
			this.next = next;
			this.obj = obj;
		}

		public Node getPre() {
			return pre;
		}

		public void setPre(Node pre) {
			this.pre = pre;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getData() {
			return obj;
		}

		public void setData(Object data) {
			this.obj = data;
		}

	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
