package headfirstdesign.chapter02.v01;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午11:57:46
 */
public class ForecastDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private float pressure;

	private Subject weatherData;

	public ForecastDisplay() {
	}

	public ForecastDisplay(Subject weatherData) {
		super();
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast Display:" + "temperature=" + temperature + ", " + "humidity=" + humidity
				+ ", pressure=" + pressure);

	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();

	}

}
