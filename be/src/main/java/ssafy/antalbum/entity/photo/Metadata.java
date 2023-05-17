package ssafy.antalbum.entity.photo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Metadata {

    private String dateTimeOriginal;
    private String timeZoneOriginal;
    private String gpsLatitudeRef;
    private String gpsLatitude;
    private String gpsLongitudeRef;
    private String gpsLongitude;
    private String altitudeRef;
    private String altitude;
    private String detectedFileTypeName;
    private String detectedMIMEType;
    private String fileName;

    public Metadata(String dateTimeOriginal, String timeZoneOriginal,
            String gpsLatitudeRef, String gpsLatitude,
            String gpsLongitudeRef, String gpsLongitude,
            String altitudeRef, String altitude,
            String detectedFileTypeName, String detectedMIMEType,
            String fileName) {

        this.dateTimeOriginal = dateTimeOriginal;
        this.timeZoneOriginal = timeZoneOriginal;
        this.gpsLatitudeRef = gpsLatitudeRef;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitudeRef = gpsLongitudeRef;
        this.gpsLongitude = gpsLongitude;
        this.altitudeRef = altitudeRef;
        this.altitude = altitude;
        this.detectedFileTypeName = detectedFileTypeName;
        this.detectedMIMEType = detectedMIMEType;
        this.fileName = fileName;
    }

}
