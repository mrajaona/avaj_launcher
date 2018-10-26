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
        conditionsChanged();
    }

    public void runSimulation(int nbSimulation) throws AvajException, IOException {
        int i = 1;

        while (i <= nbSimulation) {
            OutputManager.writeToFile(""); // cleaner input
            if (Simulator.verbose)
                OutputManager.verbose("Updating weather (" + i + "/" + nbSimulation + ")");
            changeWeather();
            i += 1;
        }
    }
}