
public class Test {

	private int num = 5;

	public Test(final int num) {
		super();
		System.out.println("1:" + this.num);
		System.out.println("2:" + num);
	}

	public int getNum() {
		return num;
	}

	public static void main(String[] args) {

		Test test = new Test(10);
		System.out.println(test.getNum());
	}

}
