package ssafy.antalbum.service;

import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.entity.FileMeta;

public interface MetadataService {
    public void upload(MultipartFile file) throws IOException;
    public S3Object download(int id);
    public List<FileMeta> list();
}
