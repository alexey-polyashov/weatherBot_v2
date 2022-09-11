package weatherbot.weather;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weatherbot.weather.dto.WeatherDto;


import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class WeatherService {

    private final WeatherConfig weatherConfig;

    public ResponseEntity<WeatherDto> getWeather(String lat, String lon){

        if(lat==null || lon==null){
            return new ResponseEntity<WeatherDto>(new WeatherDto("Не верные координаты"), HttpStatus.BAD_REQUEST);
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Yandex-API-Key", weatherConfig.getApiKey());

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<WeatherDto> response = null;
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(weatherConfig.getApiUrl())
                .queryParam("lat", "{lat}")
                .queryParam("lon", "{lon}")
                .encode()
                .toUriString();

        Map<String, String> geoCoord = new HashMap<>();
        geoCoord.put("lat", lat);
        geoCoord.put("lon", lon);

        try {
            response = restTemplate.exchange(
                    urlTemplate,
                    HttpMethod.GET,
                    request,
                    WeatherDto.class,
                    geoCoord);
        } catch(HttpClientErrorException e){
            if(e.getStatusCode()==HttpStatus.FORBIDDEN){
                response = new ResponseEntity<WeatherDto>(new WeatherDto("Нет доступа к сервису, возможно превышено максимальное количество запросов - 50 в день"), e.getStatusCode());
            } else {
                response = new ResponseEntity<WeatherDto>(new WeatherDto(e.getMessage()), e.getStatusCode());
            }
            e.printStackTrace();
        } catch(Exception e){
            response = new ResponseEntity<WeatherDto>(new WeatherDto("Ошибка при обращении к сервису"), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return response;

    }

}
