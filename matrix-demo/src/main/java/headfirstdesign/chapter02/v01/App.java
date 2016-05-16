package headfirstdesign.chapter02.v01;

/**
 * Description：
 *
 * @author matrix
 * @version 1.0
 * @time 2016年5月7日 上午11:58:02
 */
public class App {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		Observer o1 = new CurrentConditionsDisplay(weatherData);
		Observer o2 = new StatisticDisplay(weatherData);
		Observer o3 = new ForecastDisplay(weatherData);

		weatherData.setMeasuements(1.1f, 2.2f, 3.3f);

	}

}
