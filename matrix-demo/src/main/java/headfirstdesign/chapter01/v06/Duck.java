package headfirstdesign.chapter01.v06;

/**
 * Description：抽象鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午12:38:58
 */
public abstract class Duck {

	public FlyBeheavior flyBeheavior;

	public QuackBeheavior quackBeheavior;

	public Duck() {
	}

	public Duck(FlyBeheavior flyBeheavior, QuackBeheavior quackBeheavior) {
		super();
		this.flyBeheavior = flyBeheavior;
		this.quackBeheavior = quackBeheavior;
	}

	public void setFlyBeheavior(FlyBeheavior flyBeheavior) {
		this.flyBeheavior = flyBeheavior;
	}

	public void setQuackBeheavior(QuackBeheavior quackBeheavior) {
		this.quackBeheavior = quackBeheavior;
	}

	public void performFly() {
		flyBeheavior.fly();
	}

	public void performQuack() {
		quackBeheavior.quack();
	}

	public void swim() {
		System.out.println("duck swim...");
	}

	public abstract void display();

}
