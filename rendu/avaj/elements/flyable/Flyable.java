package avaj.elements.flyable;

import avaj.elements.weathertower.WeatherTower;

import avaj.exceptions.AvajException;
import java.io.IOException;

public interface Flyable {

    public void updateConditions() throws AvajException, IOException;
    public void registerTower(WeatherTower weatherTower) throws AvajException, IOException;
    public String identify() throws AvajException;

}