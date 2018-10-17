package avaj.elements.aircraft;

import avaj.elements.aircraft.Aircraft;
import avaj.elements.flyable.Flyable;

import avaj.elements.weathertower.WeatherTower;
import avaj.elements.aircraft.Coordinates;

import avaj.elements.weatherprovider.WeatherProvider;

public class Helicopter extends Aircraft implements Flyable {

    private static final String TYPE = "Helicopter";
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void log(String message) {
        System.out.println(identify() + ": " + message);
    }

    @Override
    public void updateConditions() {
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
                // ERROR
        }

        if (coordinates.getHeight() == 0) {
            land();
        }
    }

    @Override
    public void registerTower(WeatherTower tower) {
        tower.register(this);
        weatherTower = tower;
    }

    @Override
    public String identify() {
        return (TYPE + "#" + name + "(" + id + ")");
    }

    private void land() {
        log("Landing at " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight());
        weatherTower.unregister(this);
    }

}