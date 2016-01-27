package puzzler.expressive;

/**
 * Puzzle 6: Multicast </br>
 * 
 * Casts are used to convert a value from one type to another.
 * 
 * Sign extension is performed if the type of the original value is signed; zero
 * extension if it is a char, regardless of the type to which it is being
 * converted.
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P006Multicast {

	/**
	 * byte is signed type </br>
	 * char is unsigned type </br>
	 */
	public static void main(String[] args) {
		System.out.println((int) (char) (byte) -1);// 65535

	}

}
