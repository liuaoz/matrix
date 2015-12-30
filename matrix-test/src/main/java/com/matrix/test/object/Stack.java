package com.matrix.test.object;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author matrix
 *
 * @date 2015年11月13日
 * 
 */
public class Stack implements Cloneable {

	private Object[] elements;

	private int size = 0;

	private static final int DEFAULT_INITAL_CAPACITY = 16;

	public Stack() {
		this.elements = new Object[DEFAULT_INITAL_CAPACITY];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public void push(Object o) {
		ensureCapacity();
		elements[size++] = o;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}

	/* 深度克隆
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Stack result = (Stack) super.clone();
		result.elements = elements.clone();
		return result;
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Stack s = new Stack();
		s.push("aa");
		s.push("bb");
		System.out.println(s.getSize());
		Stack s2 = (Stack) s.clone();

//		s.getElements()[1] = "dd";

//		System.out.println(s.pop());
		System.out.println(s2.pop());
		System.out.println(s.pop());

	}

}