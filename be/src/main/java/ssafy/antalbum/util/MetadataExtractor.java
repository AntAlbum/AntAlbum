package ssafy.antalbum.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.IOException;
import java.io.InputStream;

public class MetadataExtractor {

    public static void extractTags(InputStream inputStream)
            throws ImageProcessingException, IOException {

        Metadata metadata = ImageMetadataReader.readMetadata(inputStream);

        for (Directory directory : metadata.getDirectories()) {
            System.out.println(directory.getName());
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();
                String description = tag.getDescription();
                String directoryName = tag.getDirectoryName();
                int tagType = tag.getTagType();
                System.out.println(tag);
                System.out.println("tagName: " + tagName + ", description: " + description + ", directoryName: " + directoryName + ", tagType: " + tagType);
                System.out.println();
            }
            System.out.println();
        }
    }

}
