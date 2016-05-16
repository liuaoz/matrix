package headfirstdesign.chapter01.v04;

/**
 * Description：哑的
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午12:21:16
 */
public class MuteQuack implements QuackBeheavior {

	@Override
	public void quack() {
		// do nothing - cant't quack
		System.out.println("MuteQuack quack..");
	}

}
