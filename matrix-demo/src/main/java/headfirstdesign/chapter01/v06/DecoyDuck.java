package headfirstdesign.chapter01.v06;

/**
 * Description：假鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:14:39
 */
public class DecoyDuck extends Duck {

	public DecoyDuck(FlyBeheavior flyBeheavior, QuackBeheavior quackBeheavior) {
		super(flyBeheavior, quackBeheavior);
	}

	public DecoyDuck() {
		super();
		this.flyBeheavior = new FlyNoWay();
		this.quackBeheavior = new MuteQuack();
	}

	@Override
	public void display() {
		System.out.println("decoy duck display..");
	}

}
