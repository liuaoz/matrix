package puzzler.expressive;

/**
 * Puzzle 5:The Joy of Hex </br>
 * 
 * negative decimal constants are clearly identifiable by the presence of a
 * minus sign. Hex and octal literals are negative if their high-order bit is
 * set.
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P005Hex {

	public static void main(String[] args) {

		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));// cafebabe
		
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));// 1cafebabe

	}
}
