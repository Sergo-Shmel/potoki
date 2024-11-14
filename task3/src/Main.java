//Сравнение производительности IO и NIO
//Задача: Напишите программу, которая читает большой текстовый файл (например, несколько мегабайт)
// двумя способами:
//
//С использованием стандартных классов IO (FileReader и BufferedReader).
//С использованием NIO (классы FileChannel, ByteBuffer, Files).
//Условия:
//
//Измерьте время выполнения каждой операции (чтение и запись файла).
//Выведите результаты на консоль для сравнения производительности.
//Критерии:
//
//Программа должна читать файл целиком и записывать его в другой файл.
//Время выполнения каждого метода должно быть замерено с помощью System.currentTimeMillis()
// или System.nanoTime().
//Сделайте выводы на основе полученных данных: какой метод быстрее для больших файлов и почему.
public class Main {
    public static void main(String[] args) {
        String inputFileName = "/Users/sergejsmelev/IdeaProjects/potoki/task3/src/largefile.txt";
        String outputFileNameIO = "/Users/sergejsmelev/IdeaProjects/potoki/task3/src/output_io.txt";
        String outputFileNameNIO = "/Users/sergejsmelev/IdeaProjects/potoki/task3/src/output_nio.txt";

        long startTimeIO = System.currentTimeMillis();
        IO.readWriteWithIO(inputFileName, outputFileNameIO);
        long endTimeIO = System.currentTimeMillis();
        System.out.println("Время выполнения с использованием IO: " + (endTimeIO - startTimeIO) + " мс");

        long startTimeNIO = System.currentTimeMillis();
        NIO.readWriteWithNIO(inputFileName, outputFileNameNIO);
        long endTimeNIO = System.currentTimeMillis();
        System.out.println("Время выполнения с использованием NIO: " + (endTimeNIO - startTimeNIO) + " мс");
    }

}

