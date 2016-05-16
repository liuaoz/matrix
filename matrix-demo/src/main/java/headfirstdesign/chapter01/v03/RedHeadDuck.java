package headfirstdesign.chapter01.v03;

/**
 * Description：红头鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:35:44
 */
public class RedHeadDuck extends Duck implements Flyable, Quackable {

	@Override
	public void display() {
		System.out.println("red head duck display...");
	}

	@Override
	public void quack() {
		System.out.println("red head duck quack..");

	}

	public void fly() {
		System.out.println("red head duck fly...");
	}

}
