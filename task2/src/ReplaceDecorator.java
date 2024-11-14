public class ReplaceDecorator extends TextDecorator{
    public ReplaceDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return super.process(text).replace(" ", "_");
    }
}
