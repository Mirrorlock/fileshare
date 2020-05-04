package com.fileshare;

import com.fileshare.models.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FileshareApplication {
    public static String STORAGE_DIR;

    public static void main(String[] args) throws IOException {
        STORAGE_DIR = new File(".").getCanonicalPath() + "/storage/";

        SpringApplication.run(FileshareApplication.class, args);
    }
}
