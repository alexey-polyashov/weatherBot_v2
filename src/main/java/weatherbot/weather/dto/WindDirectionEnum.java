package weatherbot.weather.dto;

public enum WindDirectionEnum {

    NW("северо-западное"),
    N("северное"),
    NE("северо-восточное"),
    E("восточное"),
    SE("юго-восточное"),
    S("южное"),
    SW("юго-западное"),
    W("западное"),
    C("штиль")
    ;

    WindDirectionEnum(String description){
        this.description = description;
    }
    String description;

    String getDescription(){
        return description;
    }

}
