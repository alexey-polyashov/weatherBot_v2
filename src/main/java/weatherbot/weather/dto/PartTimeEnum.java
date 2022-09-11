package weatherbot.weather.dto;

public enum PartTimeEnum {

    NIGHT("ночь"),
    MORNING("утро"),
    DAY("день"),
    EVENING("вечер");

    PartTimeEnum(String description){
        this.description = description;
    }

    private String description;

    String getDescription(){
        return description;
    }

}
