package weatherbot.geocode;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class GeoConfig {
    @Value("${dadata.api-key}")
    private String token;
    @Value("${dadata.secret-key}")
    private String secret;
    @Value("${dadata.geocod-url}")
    private String url;
//    curl -X POST \
//            -H "Content-Type: application/json" \
//            -H "Authorization: Token 0c3a80d5c22de1ab42d1ea930d4f5349c8a9a9a9" \
//            -H "X-Secret: c167cabaebc5d726cc45b5acf81f4507354726ac" \
//            -d '[ "москва сухонская 11" ]' \
//    https://cleaner.dadata.ru/api/v1/clean/address
}
