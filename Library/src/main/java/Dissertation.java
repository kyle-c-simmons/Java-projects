public class Dissertation extends Item {

    private int grade;

    public Dissertation(int item_id, String item_name, int grade) {
        super(item_id, item_name);
        this.grade = grade;
    }

    public int getWords() {
        return grade;
    }

    public void setWords(int words) {
        this.grade = words;
    }
}
