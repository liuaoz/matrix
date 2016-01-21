package puzzler;

/**
 * Puzzle 7 : Swap Meat
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P007SwapMeat {

	public static void main(String[] args) {
		int x = 1984;// (0x7c0)
		int y = 2001;// (0x7d1)
		x ^= y ^= x ^= y;
		System.out.println("x = " + x + ";y = " + y);
	}

}
