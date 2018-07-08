public class Newspaper extends Item {

    private String author;

    public Newspaper(int item_id, String item_name, String author) {
        super(item_id, item_name);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
