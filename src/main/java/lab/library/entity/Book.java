package lab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;


    public Book() {
        this.isAvailable=true;
    }

    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable=true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishYear=" + publishYear +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean returnBook() {
        setAvailable(true);
        return true;
    }

    public boolean checkOut() {
        setAvailable(false);
        return true;
    }
}