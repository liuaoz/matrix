package javase.exception;

/**
 * 功能：socket timed out
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月28日
 */
public class SocketTimeoutExceptionExample {

	public static void main(String[] args) {

		new Thread(new SimpleServer()).start();
		new Thread(new SimpleClient()).start();

	}

}