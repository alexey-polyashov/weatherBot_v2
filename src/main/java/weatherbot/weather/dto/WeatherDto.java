package weatherbot.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDto {

// РАСКОММЕНТИРОВАТЬ, ЕСЛИ БУДЕТ ИСПОЛЬЗОВАТЬСЯ ТЕСТОВЫЙ РЕЖИМ РАБОТЫ СЕРВИСА ПОГОДЫ
//    private FactWeatherDto fact;
//    private Set<ForecastsWeatherDto> forecast;
//    private String errorMessage;
//
//    public WeatherDto(String errorMessage) {
//        this.errorMessage = errorMessage;
//    }
//
//    @Override
//    public String toString() {
//
//        if(!errorMessage.isEmpty()){
//            return errorMessage;
//        }
//
//        String res = "<u><b>МЕТЕОСВОДКА</b></u>\n";
//
//        res += fact.toString();
//        if(forecast!=null) {
//            for (ForecastsWeatherDto fwd : forecast) {
//                res = res + fwd.toString();
//            }
//        }
//        res = res + "\n";
//        return res;
//
//    }


    private FactWeatherDto fact;
    private ForecastsWeatherDto forecast;
    private String errorMessage;

    public WeatherDto() {
        this.errorMessage = "";
        this.forecast = new ForecastsWeatherDto();
        this.fact = new FactWeatherDto();
    }

    public WeatherDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {

        if(!errorMessage.isEmpty()){
            return errorMessage;
        }

        String res = "<u><b>МЕТЕОСВОДКА</b></u>\n";

        res += fact.toString();
        if(forecast!=null) {
            res = res + forecast.toString();
        }
        res = res + "\n";
        return res;

    }

}
