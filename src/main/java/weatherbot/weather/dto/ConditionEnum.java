package weatherbot.weather.dto;

public enum ConditionEnum {

    CLEAR("ясно"),
    PARTLY_CLOUDY("малооблачно"),
    CLOUDY ("облачно с прояснениями"),
    OVERCAST ("пасмурно"),
    DRIZZLE ("морось"),
    LIGHT_RAIN("небольшой дождь"),
    RAIN("дождь"),
    MODERATE_RAIN ("умеренно сильный дождь"),
    HEAVY_RAIN("сильный дождь"),
    CONTINUOUS_HEAVY_RAIN("длительный сильный дождь"),
    SHOWERS ("ливень"),
    WET_SHOWERS("дождь со снегом"),
    LIGHT_SNOW("небольшой снег"),
    SNOW("снег"),
    SNOW_SHOWERS("снегопад"),
    HAIL("град"),
    THUNDERSTORM("гроза"),
    THUNDERSTORM_WITH_RAIN("дождь с грозой"),
    THUNDERSTORM_WITH_HAIL("гроза с градом")
    ;

    ConditionEnum(String description){
        this.description = description;
    }
    String description;

    String getDescription(){
        return description;
    }

}
