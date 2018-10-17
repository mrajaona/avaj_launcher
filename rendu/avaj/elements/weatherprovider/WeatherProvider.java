package avaj.elements.weatherprovider;

import avaj.elements.aircraft.Coordinates;

public class WeatherProvider {

    public static final String      RAIN = "RAIN";
    public static final String      FOG  = "FOG";
    public static final String      SUN  = "SUN";
    public static final String      SNOW = "SNOW";

    private static WeatherProvider  weatherProvider = new WeatherProvider();
    private static final String []  weather = {
        RAIN,
        FOG,
        SUN,
        SNOW
    } ;

    // TO DO : un constructeur
    private WeatherProvider() {};

    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // TO DO
        return (SNOW);
    }

}
