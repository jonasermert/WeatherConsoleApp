package com.jonasermert.weather;

import com.jonasermert.weather.utils.WeatherFetcher;

public class WeatherInfo {

    private String timestamp;
    private String temperature;

    public WeatherInfo(String timestamp, String temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTemperature() {
        return temperature;
    }
}
