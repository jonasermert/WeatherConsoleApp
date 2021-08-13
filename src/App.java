import com.jonasermert.weather.utils.WeatherFetcher;
import com.jonasermert.weather.WeatherInfo;

import java.util.Scanner;

/*
@author Jonas Ermert
@version 1.0
 */

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Created with OpenWeatherMap - Von welcher Stadt möchten Sie Wetterinformationen erhalten?");

        Scanner input = new Scanner(System.in);
        String city = input.next();

        System.out.println("Informationen zu: " + city);

        WeatherFetcher w = WeatherFetcher.getInstance();

        WeatherInfo[] weatherInfos = w.fetch(city);

        for (int x = 0; x < weatherInfos.length; x++) {
            WeatherInfo weatherInfo = weatherInfos[x];
            System.out.println(weatherInfo.getTimestamp() + ": " + weatherInfo.getTemperature());
        }


    }

}
