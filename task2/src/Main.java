import javax.annotation.processing.Processor;

// Реализация паттерна Декоратор
//Задача: Реализуйте паттерн Декоратор для обработки текста.
// Напишите набор классов, которые будут декорировать строку:
//
//Основной интерфейс TextProcessor, содержащий метод process(String text).
    //Реализуйте класс SimpleTextProcessor, который просто возвращает текст без изменений.
    //Реализуйте декораторы:
//UpperCaseDecorator — преобразует текст в верхний регистр.
//TrimDecorator — удаляет пробелы в начале и конце строки.
//ReplaceDecorator — заменяет все пробелы символом подчеркивания (_).
//Условия:
//
//Продемонстрируйте работу декораторов, комбинируя их.
//Пример использования: оберните текст в несколько декораторов и вызовите process.
public class Main {
    public static void main(String[] args) {
        TextProcessor processor = new ReplaceDecorator(
                new UpperCaseDecorator(
                        new TrimDecorator(
                                new SimpleTextProcessor()
                        )
                )
        );
        String result = processor.process(" Hello world ");
        System.out.println(result); // Вывод: HELLO_WORLD
    }
}
