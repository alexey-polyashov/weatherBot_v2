package weatherbot.weather.dto;

public enum SeasonsEnum {

    SUMMER("лето"),
    AUTUMN("осень"),
    WINTER("зима"),
    SPRING("весна");

    SeasonsEnum(String description){
        this.description = description;
    }
    String description;

    String getDescription(){
        return description;
    }

}
