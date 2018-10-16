package avaj.elements.flyable;

import avaj.elements.weathertower.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public void land();

}