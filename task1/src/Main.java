import java.io.*;

//Работа с потоками ввода-вывода
//Задача: Напишите программу, которая читает текст из файла и записывает его в другой файл с изменениями:
//
//Программа должна читать содержимое исходного файла построчно.
//Преобразовать каждую строку текста в верхний регистр.
//Записать преобразованный текст в новый файл.
//Условия:
//
//Для работы с файлами использовать классы из пакета java.io:
// BufferedReader, BufferedWriter, FileReader, FileWriter.
//Программа должна быть устойчивой к ошибкам, например, если файл не найден.
//Использовать обработку исключений через try-with-resources.
public class Main {
    public static void main(String[] args) {
        String inputFileName = "/Users/sergejsmelev/IdeaProjects/potoki/task1/src/input.txt";
        String outputFileName = "/Users/sergejsmelev/IdeaProjects/potoki/task1/src/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String upperCaseLine = line.toUpperCase();
                writer.write(upperCaseLine);
                writer.newLine();
            }

            System.out.println("Текст успешно преобразован и записан в файл " + outputFileName);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
