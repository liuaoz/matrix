package puzzler;

/**
 * Puzzle 3:LongDivision</br>
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P003LongDivision {
	public static void main(String[] args) {
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;// overflow
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

	}
}
