public class Book extends Item {

    private String book_author;

    public Book(int item_id, String book_author) {

        super(item_id, book_author);
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
}
