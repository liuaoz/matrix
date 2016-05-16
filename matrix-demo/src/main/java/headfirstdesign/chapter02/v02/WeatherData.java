package headfirstdesign.chapter02.v02;

import java.util.Observable;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 下午12:53:14
 */
public class WeatherData extends Observable {

	private float temperature;

	private float humidity;

	private float pressure;

	public WeatherData() {
		// TODO Auto-generated constructor stub
	}

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	void setMeasuements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
