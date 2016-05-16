package headfirstdesign.chapter01.v04;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午12:40:18
 */
public class App {

	public static void main(String[] args) {

		Duck d = new DecoyDuck();
		d.performFly();
		d.performQuack();
		d.display();
	}
}
