package weatherbot.weather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class DayPartsDto {
    private String part_name;
    private String temp_min;
    private String temp_max;
    private String condition;
    private String temp_avg;
    private String feels_like;
    private String wind_speed;
    private String wind_dir;
    private String wind_gust;
    private String pressure_mm;
    private String humidity;

    @Override
    public String toString() {

        String conditionValue = condition.replace("-", "_").toUpperCase(Locale.ROOT);
        String conditionDesc = ConditionEnum.valueOf(conditionValue).getDescription();

        String windDirValue = wind_dir.replace("-", "_").toUpperCase(Locale.ROOT);
        String windDirDesc = WindDirectionEnum.valueOf(windDirValue).getDescription();

        String partValue = part_name.replace("-", "_").toUpperCase(Locale.ROOT);
        String partDesc = PartTimeEnum.valueOf(partValue).getDescription();

        return "    <b>" + partDesc + ":</b>\n" +
                "      <i>" + conditionDesc + "</i>" + "\n" +
                "      Температура <i>" + temp_avg + "</i> градусов (от <i>" + temp_min + "</i> до <i>" + temp_max + "</i>)\n" +
                "           ощущается как <i>" + feels_like + "</i>\n" +
                "       Ветер <i>" + wind_speed + "</i> м/с, направление <i>" + windDirDesc + "</i>\n" +
                "       Давление <i>" + pressure_mm + "</i> мм рт. ст., влажность <i>" + humidity + "</i> %\n"
                ;
    }

}
