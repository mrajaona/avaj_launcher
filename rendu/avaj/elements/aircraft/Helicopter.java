package avaj.elements.aircraft;

import avaj.elements.aircraft.Aircraft;
import avaj.elements.flyable.Flyable;

import avaj.elements.weathertower.WeatherTower;
import avaj.elements.aircraft.Coordinates;

import avaj.elements.weatherprovider.WeatherProvider;
import avaj.elements.aircraft.AircraftFactory;

import avaj.exceptions.InvalidWeatherException;

import avaj.exceptions.AvajException;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

    private static final String TYPE = AircraftFactory.HELICOPTER;
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) throws AvajException {
        super(name, coordinates);
        type = TYPE;
    }

    @Override
    public void updateConditions() throws AvajException, IOException {
        final String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case WeatherProvider.RAIN :
                log("I'm singing in the rain.");
                coordinates.editLongitude(5);
                break;
            case WeatherProvider.FOG :
                log("I can't see.");
                coordinates.editLongitude(1);
                break;
            case WeatherProvider.SNOW :
                log("It's cold here.");
                coordinates.editHeight(-12);
                break ;
            case WeatherProvider.SUN :
                log("So bright.");
                coordinates.editLongitude(10);
                coordinates.editHeight(2);
                break ;
            default :
                throw ( new InvalidWeatherException() );
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

    private void land() throws AvajException, IOException {
        log("Landing at " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ".");
        weatherTower.unregister(this);
    }

}