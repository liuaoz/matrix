package datastructurealgorithm.chaper04;

public class StackX<T> {
	private int maxSize;
	private T[] stackArray;
	private int top;

	@SuppressWarnings("unchecked")
	public StackX(int s) {
		this.maxSize = s;
		this.stackArray = (T[]) new Object[maxSize];
		this.top = -1;
	}

	/**
	 * 将数据压入栈中
	 * 
	 * @throws Exception
	 */
	public void push(T item) {
		if (isFull()) {
			throw new RuntimeException("the stack is full.");
		}
		stackArray[++top] = item;
	}

	/**
	 * 从栈中弹出数据
	 * 
	 * @throws Exception
	 */
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty.");
		}
		return stackArray[top--];
	}

	/**
	 * 查看栈中数据
	 */
	public T peek() {
		return stackArray[top];
	}

	/**
	 * 栈是否为空
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * 栈是否满
	 */
	public boolean isFull() {
		return top == maxSize - 1;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

}
