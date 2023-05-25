package ssafy.antalbum.entity.photo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhotoMeta {

    private String dateTimeOriginal;
    private String timeZoneOriginal;
    private String gpsLatitudeRef;
    private String gpsLatitude;
    private String gpsLongitudeRef;
    private String gpsLongitude;
    private String gpsAltitudeRef;
    private String gpsAltitude;
    private String detectedFileTypeName;
    private String detectedMIMEType;
    private String expectedFileNameExtension;

    @Builder
    public PhotoMeta(String dateTimeOriginal, String timeZoneOriginal,
            String gpsLatitudeRef, String gpsLatitude,
            String gpsLongitudeRef, String gpsLongitude,
            String gpsAltitudeRef, String gpsAltitude,
            String detectedFileTypeName, String detectedMIMEType,
            String expectedFileNameExtension) {

        this.dateTimeOriginal = dateTimeOriginal;
        this.timeZoneOriginal = timeZoneOriginal;
        this.gpsLatitudeRef = gpsLatitudeRef;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitudeRef = gpsLongitudeRef;
        this.gpsLongitude = gpsLongitude;
        this.gpsAltitudeRef = gpsAltitudeRef;
        this.gpsAltitude = gpsAltitude;
        this.detectedFileTypeName = detectedFileTypeName;
        this.detectedMIMEType = detectedMIMEType;
        this.expectedFileNameExtension = expectedFileNameExtension;
    }

}
