package datastructurealgorithm.chaper04;

public class Reverse {

	public static void main(String[] str) {
		StackX<Character> s = new StackX<Character>(5);
		String word = "hello";
		for (int i = 0; i < word.length(); i++) {
			s.push(word.charAt(i));
		}

		for (int j = 0; j < s.getMaxSize(); j++) {
			System.out.print(s.pop());
		}
	}

	public static void test() {
		StackX<Integer> s = new StackX<Integer>(5);

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);

		for (int i = 0; i < 5; i++) {
			System.out.println(s.pop());
		}

		System.out.println(s.getMaxSize());
	}
}