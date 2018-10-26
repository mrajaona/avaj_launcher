package avaj.elements.weathertower;

import avaj.elements.aircraft.Coordinates;
import avaj.elements.weatherprovider.WeatherProvider;

import avaj.simulator.OutputManager;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.simulator.Simulator;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        final WeatherProvider provider    = WeatherProvider.getProvider();
        return( provider.getCurrentWeather(coordinates) );
    }

    void changeWeather() throws AvajException, IOException {
        OutputManager.writeToFile(""); // cleaner input
        if (Simulator.verbose)
            OutputManager.verbose("Updating weather");
        conditionsChanged();
    }

    public void runSimulation(int nbSimulation) throws AvajException, IOException {
        while (nbSimulation > 0) {
            changeWeather();
            nbSimulation -= 1;
        }
    }
}