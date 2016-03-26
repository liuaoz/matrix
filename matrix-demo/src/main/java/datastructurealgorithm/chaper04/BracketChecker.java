package datastructurealgorithm.chaper04;

/**
 * 功能：分隔符匹配校验
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月25日
 */
public class BracketChecker {

	public static void main(String[] args) {

		String s = "{(ssw)sd";
		check(s);

	}

	public static void check(String str) {
		int size = str.length();
		StackX<Character> s = new StackX<>(size);

		for (int i = 0; i < size; i++) {
			char c = str.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				s.push(c);
				break;
			case '}':
			case ')':
			case ']':
				if (!s.isEmpty()) {
					char ch = s.pop();
					if (c == '{' && c != '}' || c == '[' && ch != ']' || c == '(' && c != ')') {
						System.out.println("error char " + c + " at " + i);
					}
				} else {
					System.out.println("error char " + c + " at " + i);
					break;
				}

			default:
				break;
			}
		}

		if (!s.isEmpty()) {
			System.out.println("error : missing right delimiter.");
		}

	}

}
