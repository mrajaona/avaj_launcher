package avaj.elements.flyable;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.elements.weathertower.WeatherTower;

public interface Flyable {

    public void updateConditions() throws AvajException, IOException;
    public void registerTower(WeatherTower weatherTower) throws AvajException, IOException;
    public String identify() throws AvajException;

}