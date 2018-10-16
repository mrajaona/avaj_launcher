package avaj.elements.aircraft;

import avaj.elements.aircraft.Aircraft;
import avaj.elements.flyable.Flyable;

import avaj.elements.weathertower.WeatherTower;
import avaj.elements.aircraft.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    private static final TYPE = "Helicopter";
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void log(String message) {
        System.out.println(TYPE + "#" + name + "(" + id + "): " + message);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower tower) {
        tower.register(this);
        weatherTower = tower;
    }

    @Override
    public void land() {
        weatherTower.unregister(this);
        // TO DO : log current coordinates
    }

}