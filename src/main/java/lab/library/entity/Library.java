package lab.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Library {
    //    도서 목록
    private List<Book> books;
    //    도서관 이름
    private String name;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다. : "+book.getTitle());
    }

    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public boolean checkOutBook(String isbn) {
        Book neededCheckoutBook = books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);

        if (neededCheckoutBook == null) return false;

        return neededCheckoutBook.checkOut();
    }

    public boolean returnBook(String isbn) {
        Book neededReturnBook = books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);

        if (neededReturnBook == null) return false;

        return neededReturnBook.returnBook();
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public List<String> getAllBooks() {
        return books.stream()
                .map(Book::toString)  // 각 Book → String
                .collect(Collectors.toList());
    }

    public int getTotalBooks() {
        return books.size();
    }

    public long getAvailableBooksCount() {
        return books.stream().map(Book::isAvailable).count();
    }
}