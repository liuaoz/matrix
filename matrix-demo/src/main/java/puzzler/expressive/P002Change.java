package puzzler.expressive;

import java.math.BigDecimal;

/**
 * Puzzle 2:Time for a change </br>
 * 
 * Always use the BigDecimal(String) constructor, never BigDecimal(double).</br>
 * In summary, avoid float and double where exact answers are required; for
 * monetary calculations, use int, long, or BigDecimal
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P002Change {
	public static void main(String[] args) {
		System.out.println(2 - 1.1);// 0.8999999999999999
		System.out.printf("%.2f%n", 2.00 - 1.10); // 0.90

		System.out.println(new BigDecimal("2").subtract(new BigDecimal("1.1")));// 0.9

		System.out.println(new BigDecimal(2).subtract(new BigDecimal(1.1)));// 0.899999999999999911182158029987476766109466552734375

		double a = 2;
		double b = 1.1;
		System.out.println(a - b);// 0.8999999999999999

		float a1 = 2;
		float b1 = 1.1f;
		System.out.println(a1 - b1);// 0.9
	}
}
