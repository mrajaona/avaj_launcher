package avaj.elements.aircraft;

import avaj.elements.aircraft.Aircraft;
import avaj.elements.flyable.Flyable;

import avaj.elements.weathertower.WeatherTower;
import avaj.elements.aircraft.Coordinates;

import avaj.elements.weatherprovider.WeatherProvider;
import avaj.elements.aircraft.AircraftFactory;

import avaj.simulator.OutputManager;

import avaj.exceptions.AvajException;
import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {

    private static final String TYPE = AircraftFactory.BALOON;
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void log(String message) throws AvajException, IOException {
        OutputManager.writeToFile(identify() + ": " + message);
    }

    @Override
    public void updateConditions() throws AvajException, IOException {
        final String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case WeatherProvider.RAIN :
                log("What a glorious feeling. I'm happy again.");
                coordinates.editHeight(-5);
                break;
            case WeatherProvider.FOG :
                log("I think I'm in a cloud.");
                coordinates.editHeight(-3);
                break;
            case WeatherProvider.SNOW :
                log("Why is snow so heavy ?");
                coordinates.editHeight(-15);
                break ;
            case WeatherProvider.SUN :
                log("I'm on fire!");
                coordinates.editLongitude(2);
                coordinates.editHeight(4);
                break ;
            default :
                // throw new InvalidWeatherException();
        }

        if (coordinates.getHeight() == 0) {
            land();
        }
    }

    @Override
    public void registerTower(WeatherTower tower) throws AvajException, IOException {
        tower.register(this);
        weatherTower = tower;
    }

    @Override
    public String identify() {
        return (TYPE + "#" + name + "(" + id + ")");
    }

    private void land() throws AvajException, IOException {
        log("Landing at " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ".");
        weatherTower.unregister(this);
    }

}