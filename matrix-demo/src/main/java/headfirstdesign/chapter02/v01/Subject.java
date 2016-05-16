package headfirstdesign.chapter02.v01;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午11:35:54
 */
public interface Subject {

	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObservers();
}
