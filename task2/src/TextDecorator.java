abstract class TextDecorator implements TextProcessor {
    protected TextProcessor processor;

    public TextDecorator(TextProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String text) {
        return processor.process(text);
    }
}
