package headfirstdesign.chapter01.v01;

/**
 * Description：抽象鸭子
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月6日 下午11:41:15
 */
public abstract class Duck {

	public void quack() {
		System.out.println("duck quack...");
	}

	public void swim() {
		System.out.println("duck swim...");
	}

	public abstract void display();

}
