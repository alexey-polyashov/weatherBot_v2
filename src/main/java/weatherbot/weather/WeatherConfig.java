package weatherbot.weather;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class WeatherConfig {
    @Value("${yandex.api-weather-url}")
    private String apiUrl;
    @Value("${yandex.weather.api-key}")
    private String apiKey;
}
