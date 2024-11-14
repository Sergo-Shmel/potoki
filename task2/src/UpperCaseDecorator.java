public class UpperCaseDecorator extends TextDecorator{
    public UpperCaseDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return super.process(text).toUpperCase();
    }
}
