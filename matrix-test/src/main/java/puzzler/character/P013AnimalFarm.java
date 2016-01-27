package puzzler.character;

/**
 * Puzzle 13: Animal Farm
 * 
 * @author matrix
 *
 * @date 2016年1月21日
 */
public class P013AnimalFarm {

	public static void main(String[] args) {
		String pig = "length: 10";
		String dog = "length: " + pig.length();
		System.out.println(dog);
		System.out.println("Animals are equal: " + pig == dog);

	}
}
