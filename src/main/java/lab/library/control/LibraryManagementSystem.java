package lab.library.control;

import lab.library.entity.Book;
import lab.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {
    private static Library library;

    public static void main(String[] args) {
        library = new Library("중앙 도서관");
        addSampleBooks();

        displayLibraryStatus();
        testFindBook();
        testCheckout();
        displayLibraryStatus();
        testReturn();
        displayLibraryStatus();
        displayAvailableBooks();
    }

    private static void addSampleBooks() {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    private static void displayLibraryStatus() {
        long available = library.getAvailableBooks().size();
        long total = library.getTotalBooks();
        long checkedOut = total - available;
        System.out.println("===== " + library.getName() + " =====");
        System.out.println("전체 도서 수: " + total);
        System.out.println("대출 가능 도서 수: " + available);
        System.out.println("대출 중인 도서 수: " + checkedOut);
        System.out.println();
    }

    private static void testFindBook() {
        System.out.println("===== 도서 검색 테스트 =====");
        library.findBookByTitle("자바의 정석").ifPresentOrElse(
                b -> System.out.println("제목으로 검색 결과: " + formatBook(b)),
                () -> System.out.println("제목으로 검색 결과: 없음")
        );

        List<Book> authorBooks = library.findBooksByAuthor("Robert C. Martin");
        System.out.println("저자로 검색 결과:");
        authorBooks.forEach(b -> System.out.println(formatBook(b)));
        System.out.println();
    }

    private static void testCheckout() {
        System.out.println("===== 도서 대출 테스트 =====");
        boolean result = library.checkOutBook("978-89-01-14077-4");
        System.out.println(result ? "도서 대출 성공!" : "도서 대출 실패!");
        library.findBookByIsbn("978-89-01-14077-4").ifPresent(b ->
                System.out.println("대출된 도서 정보: " + formatBook(b))
        );
        System.out.println();
    }

    private static void testReturn() {
        System.out.println("===== 도서 반납 테스트 =====");
        boolean result = library.returnBook("978-89-01-14077-4");
        System.out.println(result ? "도서 반납 성공!" : "도서 반납 실패!");
        library.findBookByIsbn("978-89-01-14077-4").ifPresent(b ->
                System.out.println("반납된 도서 정보: " + formatBook(b))
        );
        System.out.println();
    }

    private static void displayAvailableBooks() {
        System.out.println("===== 대출 가능 도서 목록 =====");
        library.getAvailableBooks().forEach(b -> System.out.println(formatBook(b)));
        System.out.println();
    }

    private static String formatBook(Book b) {
        return "책 제목: " + b.getTitle() +
                "   저자: " + b.getAuthor() +
                "   ISBN: " + b.getIsbn() +
                "   출판년도: " + b.getPublishYear() +
                "   대출 가능 여부: " + (b.isAvailable() ? "가능" : "대출 중");
    }
}
