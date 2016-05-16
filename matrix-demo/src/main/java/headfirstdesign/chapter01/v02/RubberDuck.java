package headfirstdesign.chapter01.v02;

/**
 * Description：橡皮鸭
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:42:29
 */
public class RubberDuck extends Duck {

	@Override
	public void display() {
		System.out.println("rubber duck display...");

	}

	@Override
	public void fly() {
		System.out.println("rubber duck can't fly..");
	}

}
