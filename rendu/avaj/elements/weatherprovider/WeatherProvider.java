package avaj.elements.weatherprovider;

import avaj.elements.aircraft.Coordinates;

public class WeatherProvider {

    private static final String     RAIN = "RAIN";
    private static final String     FOG  = "FOG";
    private static final String     SUN  = "SUN";
    private static final String     SNOW = "SNOW";

    private static WeatherProvider  weatherProvider;
    private static final String []  weather = {
        RAIN,
        FOG,
        SUN,
        SNOW
    } ;

    // TO DO : un constructeur
    private WeatherProvider() {
        weatherProvider = this;
    };

    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

}
