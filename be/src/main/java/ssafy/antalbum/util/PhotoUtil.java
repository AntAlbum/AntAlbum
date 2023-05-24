package ssafy.antalbum.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import ssafy.antalbum.entity.photo.PhotoMeta;

public class PhotoUtil {

    public static PhotoMeta extractMetaData(
            InputStream inputStream) throws ImageProcessingException, IOException {

        Metadata metadata = ImageMetadataReader.readMetadata(inputStream);

        ExifSubIFDDirectory sub_dir = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        Date datetime = sub_dir == null ? null : sub_dir.getDate(ExifIFD0Directory.TAG_DATETIME_ORIGINAL);
        String timeZone = sub_dir == null ? "" : sub_dir.getString(ExifIFD0Directory.TAG_TIME_ZONE_ORIGINAL);

        GpsDirectory gps_dir = metadata.getFirstDirectoryOfType(GpsDirectory.class);
        String latitude_ref = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_LATITUDE_REF);
        String latitude = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_LATITUDE);
        String longitude_ref = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_LONGITUDE_REF);
        String longitude = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_LONGITUDE);
        String altitude_ref = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_ALTITUDE_REF);
        String altitude = gps_dir == null ? "" : gps_dir.getString(GpsDirectory.TAG_ALTITUDE);

        FileTypeDirectory type_dir = metadata.getFirstDirectoryOfType(FileTypeDirectory.class);
        String detected_type = type_dir == null ? "" : type_dir.getString(FileTypeDirectory.TAG_DETECTED_FILE_TYPE_NAME);
        String detected_mime = type_dir == null ? "" : type_dir.getString(FileTypeDirectory.TAG_DETECTED_FILE_MIME_TYPE);

        PhotoMeta photoMeta = PhotoMeta.builder()
                .dateTimeOriginal(datetime == null ? null : datetime.toString())
                .timeZoneOriginal(timeZone)
                .gpsLatitudeRef(latitude_ref)
                .gpsLatitude(latitude)
                .gpsLongitudeRef(longitude_ref)
                .gpsLongitude(longitude)
                .gpsAltitudeRef(altitude_ref)
                .gpsAltitude(altitude)
                .detectedFileTypeName(detected_type)
                .detectedMIMEType(detected_mime)
                .build();

        return photoMeta;
    }

}
