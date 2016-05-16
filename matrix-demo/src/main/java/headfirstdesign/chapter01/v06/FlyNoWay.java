package headfirstdesign.chapter01.v06;

public class FlyNoWay implements FlyBeheavior {

	@Override
	public void fly() {
		// do nothing - can't fly
		System.out.println("FlyNoWay fly...");
	}

}
