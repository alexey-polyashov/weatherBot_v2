package weatherbot.weather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class FactWeatherDto {

    private final String icon_url = "https://yastatic.net/weather/i/icons/funky/dark/";

    private String temp;
    private String feels_like;
    private String wind_speed;
    private String wind_dir;
    private String pressure_mm;
    private String humidity;
    private String icon;
    private String season;
    private String condition;

    @Override
    public String toString() {

        String seasonValue = season.replace("-", "_").toUpperCase(Locale.ROOT);
        String seasonDesc = SeasonsEnum.valueOf(seasonValue).getDescription();

        String conditionValue = condition.replace("-", "_").toUpperCase(Locale.ROOT);
        String conditionDesc = ConditionEnum.valueOf(conditionValue).getDescription();

        String windDirValue = wind_dir.replace("-", "_").toUpperCase(Locale.ROOT);
        String windDirDesc = WindDirectionEnum.valueOf(windDirValue).getDescription();

        return "<u><b>Текущая погода:</b></u>\n" +
                "Текущее время года <i>" + seasonDesc + "</i>\n" +
                "На улице <i>" + conditionDesc + "</i>" + "\n" +
                "Температура <i>" + temp + "</i> градусов\n"
                + "   ощущается как <i>" + feels_like + "</i>\n"
                + "Ветер <i>" + wind_speed + "</i> м/с, Направление <i>" + windDirDesc + "</i>\n"
                + "Давление <i>" + pressure_mm + "</i> мм рт. ст., Влажность <i>" + humidity + "</i> %\n"
                ;
    }
}
