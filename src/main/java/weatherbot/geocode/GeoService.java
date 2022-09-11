package weatherbot.geocode;

import weatherbot.geocode.dto.GeoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@AllArgsConstructor
public class GeoService {

    private final GeoConfig geoConfig;

    public ResponseEntity<GeoResponseDto> getCoordinates(String address){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Token " + geoConfig.getToken());
        headers.add("X-Secret", geoConfig.getSecret());

        HttpEntity<String> request = new HttpEntity("[\"" + address + "\"]", headers);

        ResponseEntity<List<GeoResponseDto>> response = null;
        ResponseEntity<GeoResponseDto> response1 = null;

        try {
            response = restTemplate.exchange(geoConfig.getUrl(), HttpMethod.POST, request, new ParameterizedTypeReference<List<GeoResponseDto>>(){});
            response1 = new ResponseEntity<GeoResponseDto>(response.getBody().get(0), response.getStatusCode());
        } catch(HttpClientErrorException e){
            if(e.getStatusCode()== HttpStatus.FORBIDDEN){
                response1 = new ResponseEntity<GeoResponseDto>(new GeoResponseDto("Нет доступа к сервису, возможно превышено максимальное количество запросов - 50 в день"), e.getStatusCode());
            } else {
                response1 = new ResponseEntity<GeoResponseDto>(new GeoResponseDto(e.getMessage()), e.getStatusCode());
            }
            e.printStackTrace();
        } catch(Exception e){
            response1 = new ResponseEntity<GeoResponseDto>(new GeoResponseDto("Ошибка при обращении к сервису"), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return response1;

    }

}
