package weatherbot.weather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ForecastsWeatherDto {
    private String date;
    private Set<DayPartsDto> parts;
    private String sunrise;
    private String sunset;

    @Override
    public String toString() {
        String res = "<u><b>Прогноз на " + date + ":</b></u>\n";
        if(parts!=null) {
            for (DayPartsDto dpd : parts) {
                res = res + dpd.toString();
            }
        }
        res = res + "\n";
        return res;
    }
}
