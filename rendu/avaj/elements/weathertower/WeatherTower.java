package avaj.elements.weathertower;

import avaj.elements.aircraft.Coordinates;
import avaj.elements.weatherprovider.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        // TO DO : get associated weather
        // return (weatherProvider.getCurrentWeather(coordinates));
        return ("SUN");
    }

    void changeWeather() {
        // TO DO : update all coordinates
        conditionsChanged();
    }
}