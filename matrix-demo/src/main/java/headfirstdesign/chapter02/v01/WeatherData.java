package headfirstdesign.chapter02.v01;

import java.util.ArrayList;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午11:37:29
 */
public class WeatherData implements Subject {

	private ArrayList<Observer> observers;

	private float temperature;

	private float humidity;

	private float pressure;

	public WeatherData() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(temperature, humidity, pressure);
		}
	}

	public ArrayList<Observer> getObservers() {
		return observers;
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

	void measurementsChanged() {
		notifyObservers();
	}

	/**
	 * 设置新的天气情况,并通知订阅者
	 * 
	 * @param temperature
	 *            温度
	 * @param humidity
	 *            湿度
	 * @param pressure
	 *            气压
	 */
	void setMeasuements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
