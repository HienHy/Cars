package helper;

public class ComboBoxItem {
    private  String text;
    private Integer value;

    public ComboBoxItem() {
    }

    public ComboBoxItem(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
