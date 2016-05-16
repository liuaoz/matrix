package headfirstdesign.chapter02.v02;

public class App {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();

		new CurrentConditionsDisplay(weatherData);

		weatherData.setMeasuements(1.1f, 2.2f, 3.3f);

	}

}
