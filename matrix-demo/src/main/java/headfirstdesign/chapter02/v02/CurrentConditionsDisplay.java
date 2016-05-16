package headfirstdesign.chapter02.v02;

import java.util.Observable;
import java.util.Observer;

import headfirstdesign.chapter02.v01.Subject;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 下午12:58:00
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private Observable observable;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions:" + " temperature=" + temperature + ", humidity=" + humidity);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}

	}

}
