package chapter8.labs.lab2;

import jdk.jfr.Category;

import java.util.*;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템의 주요 기능을 구현한 클래스입니다.
 */
public class LibraryManager {
    // 도서 목록 (ArrayList 활용)
    private List<Book> books;
    
    // 사용자별 대여 현황 (HashMap 활용)
    private Map<String, List<Book>> userBorrowMap;
    
    // 도서 카테고리 (HashSet 활용)
    private Set<String> categories;
    
    /**
     * 생성자
     */
    public LibraryManager() {
        // TODO: 필드를 초기화하세요.
        this.books = new ArrayList<Book>();
        this.userBorrowMap = new HashMap<String, List<Book>>();
        this.categories = new HashSet<>();
    }
    
    /**
     * 도서 추가 메소드
     */
    public void addBook(Book book) {
        // TODO: 도서를 추가하고, 카테고리도 Set에 추가하세요.
        books.add(book);
        categories.add(book.getCategory());
    }
    
    /**
     * 도서 검색 메소드 (제목으로 검색)
     */
    public List<Book> searchBooksByTitle(String title) {
        // TODO: 제목에 검색어가 포함된 도서를 검색하세요.
        List<Book> targetBooks = new ArrayList<Book>();
        for (Book b:books) {
            if (b.getTitle().contains(title)) {
                targetBooks.add(b);
            }
        }
        return targetBooks;
    }
    
    /**
     * 도서 검색 메소드 (저자로 검색)
     */
    public List<Book> searchBooksByAuthor(String author) {
        // TODO: 저자명으로 도서를 검색하세요.
        List<Book> targetBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                targetBooks.add(b);
            }
        }
        return targetBooks;
    }
    
    /**
     * 도서 대여 메소드
     */
    public boolean borrowBook(String userId, String isbn) {
        // TODO: 도서를 대여하고, 사용자별 대여 현황을 업데이트하세요.
        for (Book b: books) {
            if (b.getIsbn().equals(isbn)){
                if (userBorrowMap.containsKey(userId)) {
                    userBorrowMap.get(userId).add(b);
                } else {
                    userBorrowMap.put(userId, new ArrayList<>(Arrays.asList(b)));
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * 도서 반납 메소드
     */
    public boolean returnBook(String userId, String isbn) {
        // TODO: 도서를 반납하고, 사용자별 대여 현황을 업데이트하세요.
        List<Book> borrowed = userBorrowMap.get(userId);
        if (borrowed == null) {
            return false;
        }

        for (Book b : borrowed) {
            if (b.getIsbn().equals(isbn)) {
                borrowed.remove(b); // 같은 객체니까 remove 가능
                return true;
            }
        }
        return false;
    }
    
    /**
     * 사용자의 대여 도서 목록 조회 메소드
     */
    public List<Book> getBorrowedBooks(String userId) {
        // TODO: 사용자가 대여한 도서 목록을 반환하세요.
        if (!userBorrowMap.containsKey(userId)) {
            return null;
        }
        return userBorrowMap.get(userId);
    }
    
    /**
     * 도서 정렬 메소드 (제목 기준)
     */
    public List<Book> getSortedBooksByTitle() {
        // TODO: 제목 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> clonedBooks = books;
        Collections.sort(clonedBooks, new Comparator<Book> () {
            @Override
            public int compare(Book b1, Book b2) {return b1.getTitle().compareTo(b2.getTitle());}
        }); // 람다 변환 가능
        return clonedBooks; // 복제하지 않고 books로 정렬하면 원본이 바뀌기 때문에 복제 후 정렬하기
    }
    
    /**
     * 도서 정렬 메소드 (출판년도 기준)
     */
    public List<Book> getSortedBooksByYear() {
        // TODO: 출판년도 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> clonedBooks = books;
        Collections.sort(clonedBooks, (b1, b2) -> Integer.compare(b1.getPublicationYear(),b2.getPublicationYear()));
        return clonedBooks;
    }
    
    /**
     * 도서 정렬 메소드 (가격 기준)
     */
    public List<Book> getSortedBooksByPrice() {
        // TODO: 가격 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> clonedBooks = books;
        Collections.sort(clonedBooks, (b1,b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
        return clonedBooks;
    }
    
    /**
     * 카테고리 목록 조회 메소드
     */
    public Set<String> getCategories() {
        // TODO: 모든 카테고리를 반환하세요.
        return categories;
    }
    
    /**
     * 카테고리별 도서 목록 조회 메소드
     */
    public List<Book> getBooksByCategory(String category) {
        // TODO: 특정 카테고리에 속한 도서 목록을 반환하세요.
        List<Book> targetBooks = new ArrayList<>();
        for (Book b:books) {
            if (b.getCategory().equals(category)){
                targetBooks.add(b);
            }
        }
        return targetBooks;
    }
    
    /**
     * 전체 도서 목록 조회 메소드
     */
    public List<Book> getAllBooks() {
        // TODO: 전체 도서 목록을 반환하세요.
        return books;
    }
} 