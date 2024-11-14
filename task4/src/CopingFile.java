import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class CopingFile {
    public static void copyFileUsingNIO(String sourceFileName, String destinationFileName) throws IOException {
        Path sourcePath = Paths.get(sourceFileName);
        Path destinationPath = Paths.get(destinationFileName);

        if (!Files.exists(sourcePath)) {
            throw new IOException("Исходный файл не найден: " + sourceFileName);
        }

        if (!Files.exists(destinationPath.getParent())) {
            Files.createDirectories(destinationPath.getParent());
        }

        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            long fileSize = sourceChannel.size();
            long transferred = 0;

            while (transferred < fileSize) {
                transferred += sourceChannel.transferTo(transferred, fileSize - transferred, destinationChannel);
            }
        }
    }
}
