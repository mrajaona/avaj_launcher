package avaj.elements.aircraft;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.exceptions.InvalidWeatherException;

import avaj.elements.aircraft.Aircraft;
import avaj.elements.flyable.Flyable;

import avaj.elements.weathertower.WeatherTower;
import avaj.elements.aircraft.Coordinates;

import avaj.elements.weatherprovider.WeatherProvider;
import avaj.elements.aircraft.AircraftFactory;

public class JetPlane extends Aircraft implements Flyable {

    private static final String TYPE = AircraftFactory.JETPLANE;
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) throws AvajException {
        super(name, coordinates);
        type = TYPE;
    }

    @Override
    public void updateConditions() throws AvajException, IOException {
        final String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case WeatherProvider.RAIN :
                log("Just singing in the rain.");
                coordinates.editLatitude(5);
                break;
            case WeatherProvider.FOG :
                log("Quite foggy here.");
                coordinates.editLatitude(1);
                break;
            case WeatherProvider.SNOW :
                log("What's this? There's white things in the air.");
                coordinates.editHeight(-7);
                break ;
            case WeatherProvider.SUN :
                log("So hot.");
                coordinates.editLatitude(10);
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
    public void registerTower(WeatherTower weatherTower) throws AvajException, IOException {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    private void land() throws AvajException, IOException {
        log("Landing at " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ".");
        weatherTower.unregister(this);
    }

}