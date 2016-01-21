package puzzler;

/**
 * Puzzle 1:Oddity </br>
 * 
 * (a/b)*b +(a%b) ==a
 * 
 * In other words, if you divide a by b, multiply the result by b, and add the
 * remainder, you are back where you started </br>
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P001Oddity {

	public static void main(String[] args) {
		System.out.println(isOddWrong(-3));
		System.out.println(isOddRight(-3));
	}

	/**
	 * 判断是否为奇数（wrong）
	 * 
	 * @param i
	 * @return
	 */
	public static boolean isOddWrong(int i) {
		return i % 2 == 1;
	}

	/**
	 * 判断是否为奇数（right）
	 * 
	 * @param i
	 * @return
	 */
	public static boolean isOddRight(int i) {
		return i % 2 != 0;
	}
}
