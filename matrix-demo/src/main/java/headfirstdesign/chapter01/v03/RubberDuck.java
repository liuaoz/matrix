package headfirstdesign.chapter01.v03;

/**
 * Description：橡皮鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:35:29
 */
public class RubberDuck extends Duck implements Quackable {

	@Override
	public void display() {
		System.out.println("rubber duck display....");

	}

	@Override
	public void quack() {
		System.out.println("rubber duck quack...");
	}

}
