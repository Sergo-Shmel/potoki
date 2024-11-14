import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIO {
    static void readWriteWithNIO(String inputFileName, String outputFileName) {
        try (FileChannel inputChannel = FileChannel.open(Paths.get(inputFileName), StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(Paths.get(outputFileName), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inputChannel.read(buffer) > 0) {
                buffer.flip();
                outputChannel.write(buffer);
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
