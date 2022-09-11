package weatherbot.geocode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoResponseDto {

    private String errorMessage;
    private String geo_lat;
    private String geo_lon;
    private String result;
    private String qc_geo;

    public GeoResponseDto() {
        this.errorMessage = "";
        this.geo_lat = "5";
        this.geo_lon = "1";
        this.result = "";
        this.qc_geo = "1";
    }

    public GeoResponseDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {

        if(!errorMessage.isEmpty()){
            return errorMessage;
        }

        if(qc_geo.equals(5)){
            return "Место не определено";
        }

        String res = result + "\n"+
                    "LAT = " + geo_lat + "; LON = " + geo_lon;

        return res;

    }

}
