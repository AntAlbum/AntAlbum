package ssafy.antalbum.entity.photo;

import jakarta.persistence.Embeddable;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhotoPath {

    private String url;
    private String encodedFileName;
    private String originalFileName;

    @Builder
    public PhotoPath(String url, String encodedFileName, String originalFileName) {
        this.url = url;
        this.encodedFileName = encodedFileName;
        this.originalFileName = originalFileName;
    }

    public static PhotoPath createPhotoPath(String bucketName, String travel_id, String fileName, String extension) {
        return PhotoPath.builder()
                .url(String.format("%s/%s", bucketName, travel_id))
                .encodedFileName(String.format("%s.%s", String.valueOf(UUID.randomUUID()), extension))
                .originalFileName(fileName)
                .build();
    }

}
