package javase.refference;

/**
 * 功能：值传递 <br>
 * java中所传递的所有东西都是值
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月15日
 */
public class RefferenceDemo {
	int a = 5;

	public static void main(String[] args) {

		int aa = 10;

		test(aa);
		System.out.println(aa);

	}

	public static void test(int id) {
		id = 2;
	}

}

class Test {
	int id;
	String name;
}
