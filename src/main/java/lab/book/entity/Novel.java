package lab.book.entity;

public class Novel extends Publication{
    private String author;
    private String genre;

    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
