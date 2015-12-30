package com.matrix.test.map;

/**
 * 节点信息
 * 
 * @author matrix
 *
 * @date 2015年11月12日
 * 
 */
public class Node {
		private Node pre;
		private Node next;
		private Object data;

		public Node(Node pre, Node next, Object data) {
			super();
			this.pre = pre;
			this.next = next;
			this.data = data;
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
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
}
