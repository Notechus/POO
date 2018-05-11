package me.notechus.poo.lista8.zad1;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

/**
 * @author Sebastian Paulus
 */
public class MyFileUtils {

    private static final Logger log = LoggerFactory.getLogger(MyFileUtils.class);
    private static final int BYTE_SIZE = 1024;
    private static final Random rand = new Random();

    public static void downloadFileFromFTP(String sourceFileName, String serverURL) {
        try (OutputStream outputStream = new FileOutputStream(sourceFileName);) {
            FTPClient client = new FTPClient();
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);

            client.retrieveFile(serverURL, outputStream);
        } catch (java.io.IOException e) {
            log.error("Could not download the file {}", sourceFileName, e);
        }
    }

    public static void downloadFileFromHTTP(String sourceFileName, String serverURL) {
        try {
            URL url = new URL(serverURL);
            Path targetPath = new File(sourceFileName).toPath();
            Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (java.io.IOException e) {
            log.error("Could not download the file {}", sourceFileName, e);
        }
    }

    public static Path createFile(String fileName) throws IOException {
        return Files.createFile(Paths.get(fileName));
    }

    public static void randomizeFile(Path file) {
        try {
            byte[] bytes = new byte[BYTE_SIZE];
            rand.nextBytes(bytes);
            Files.write(file, bytes);
        } catch (IOException e) {
            log.error("Could not create file {}", file, e);
        }
    }

    public static void createRandomFile(String fileName) {
        try {
            randomizeFile(createFile(fileName));
        } catch (IOException e) {
            log.error("Could not create file {}", fileName, e);
        }
    }

    public static void copyFile(String sourceFile, String targetFile) {
        try {
            Files.copy(Paths.get(sourceFile), Paths.get(targetFile));
        } catch (IOException e) {
            log.error("Could not copy file {} to {}", sourceFile, targetFile, e);
        }
    }
}
