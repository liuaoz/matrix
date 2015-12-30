import java.util.Arrays;

/**
 * 测试类
 * 
 * @author matrix
 *
 * @date 2015年11月13日
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		String str = "aaa=bbb";
		String[] arr = str.split("&");
		System.out.println(Arrays.toString(arr));
	}

}
