public class Dissertations extends Items {

    private int grade;

    public Dissertations(int item_id, String item_name, int grade) {
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
