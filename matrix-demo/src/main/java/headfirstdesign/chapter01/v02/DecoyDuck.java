package headfirstdesign.chapter01.v02;

/**
 * Description：假鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:14:39
 */
public class DecoyDuck extends Duck {

	@Override
	public void display() {
		System.out.println("decoy duck display");
	}
	
	@Override
	public void fly() {
		System.out.println("decoy duck fly");
	}

}
