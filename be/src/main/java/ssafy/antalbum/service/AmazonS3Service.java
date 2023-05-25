package ssafy.antalbum.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ssafy.antalbum.entity.photo.PhotoPath;

@Service
public class AmazonS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public String upload(
            PhotoPath photoPath, Map<String, String> metadata, InputStream inputStream) {

        ObjectMetadata objectMetadata = new ObjectMetadata();
        Optional<Map<String, String>> optionalMetaData = Optional.of(metadata);
        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(objectMetadata::addUserMetadata);
            }
        });

        PutObjectResult objectResult = amazonS3.putObject(
                photoPath.getUrl(), photoPath.getEncodedFileName(), inputStream, objectMetadata);

        String path = String.format("%s/%s", photoPath.getUrl().split("/")[1], photoPath.getEncodedFileName());
        return amazonS3.getUrl(bucketName, path).toString();
    }

}
