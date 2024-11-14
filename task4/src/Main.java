import java.io.IOException;

//Программа с использованием Java NIO
//Задача: Напишите программу, которая копирует файл с использованием Java NIO.
//
//Использовать FileChannel для чтения и записи данных.
//Программа должна поддерживать возможность копирования больших файлов (> 1 Гб).
//Реализовать обработку исключений, связанных с доступом к файлу или его отсутствием.
//Условия:
//
//Используйте методы transferTo() или transferFrom() из FileChannel для копирования содержимого.
//Программа должна быть устойчива к прерыванию работы и сообщать об ошибках.
//        Критерии:
//
//Корректная работа с большими файлами.
//Использование механизмов NIO и сравнение производительности с классическим IO (опционально).
//
public class Main {
    public static void main(String[] args) {
        String sourceFileName = "/Users/sergejsmelev/IdeaProjects/potoki/task4/src/source.txt";
        String destinationFileName = "/Users/sergejsmelev/IdeaProjects/potoki/task4/src/destination.txt";

        try {
            CopingFile.copyFileUsingNIO(sourceFileName, destinationFileName);
            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}