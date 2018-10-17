package avaj.elements.weathertower;

import avaj.elements.aircraft.Coordinates;
import avaj.elements.weatherprovider.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider provider    = WeatherProvider.getProvider();

        return( provider.getCurrentWeather(coordinates) );
    }

    void changeWeather() {
        conditionsChanged();
    }

    public void runSimulation(int nbSimulation) {
        while (nbSimulation >= 0) {
            changeWeather();
            nbSimulation -= 1;
        }
    }
}