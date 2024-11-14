import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;

public class AsyncFileReader {
    static void readFileAsync(AsynchronousFileChannel fileChannel, ByteBuffer buffer, long position) {
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer bytesRead, ByteBuffer buffer) {
                if (bytesRead > 0) {
                    buffer.flip();
                    byte[] data = new byte[bytesRead];
                    buffer.get(data);
                    System.out.print(new String(data));
                    buffer.clear();

                    readFileAsync(fileChannel, buffer, position + bytesRead);
                } else {
                    System.out.println("\nЧтение файла завершено.");
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer buffer) {
                System.err.println("Ошибка при чтении файла: " + exc.getMessage());
            }
        });
    }
}
