package headfirstdesign.chapter01.v03;

/**
 * Description：野鸭
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:21:40
 */
public class MallardDuck extends Duck implements Flyable, Quackable {

	@Override
	public void display() {
		System.out.println("mallard duck display..");

	}

	@Override
	public void quack() {
		System.out.println("mallard duck quack...");

	}

	public void fly() {
		System.out.println("mallard duck fly..");
	}

}
