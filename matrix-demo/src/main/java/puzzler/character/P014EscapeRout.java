package puzzler.character;

/**
 * Puzzle:14 Escape Rout
 * 
 * Java provides no special treatment for Unicode escapes within string literals
 * 
 * @author matrix
 *
 * @date 2016年1月22日
 */
public class P014EscapeRout {

	public static void main(String[] args) {
		// \u0022 is the Unicode escape for double-quote ( )
		System.out.println("a\u0022.length() + \u0022b".length()); // 2
		System.out.println("a\".length() + \"b".length());// 16

	}
}
