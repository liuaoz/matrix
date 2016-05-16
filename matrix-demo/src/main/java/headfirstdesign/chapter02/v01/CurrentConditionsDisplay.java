package headfirstdesign.chapter02.v01;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午11:56:32
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private Subject weatherData;

	public CurrentConditionsDisplay() {
	}

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("CurrentCondition: temperature=" + temperature + ", humidity=" + humidity);
	}

}
