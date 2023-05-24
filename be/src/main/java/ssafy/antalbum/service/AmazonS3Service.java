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
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.entity.photo.PhotoPath;
import ssafy.antalbum.util.PhotoUtil;

@Service
public class AmazonS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    public PutObjectResult upload(
            PhotoPath photoPath, Map<String, String> metadata, InputStream inputStream) {

        ObjectMetadata objectMetadata = new ObjectMetadata();
        Optional<Map<String, String>> optionalMetaData = Optional.of(metadata);
        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(objectMetadata::addUserMetadata);
            }
        });

        return amazonS3.putObject(
                photoPath.getUrl(), photoPath.getEncodedFileName(), inputStream, objectMetadata);
    }
}
