package chapter8.labs.lab2;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    /**
     * 메뉴 표시 메서드
     */
    private static void displayMenu() {
        System.out.println("== Library App ==");
        System.out.println("1. 전체 도서 목록 보기");
        System.out.println("2. 도서 검색하기");
        System.out.println("3. 도서 대여하기");
        System.out.println("4. 도서 반납하기");
        System.out.println("5. 도서 추가하기");
        System.out.println("6. 나의 대여 도서 목록 보기");
        System.out.println("7. 카테고리 별 도서 목록 보기");
        System.out.println("0. 종료");
    }

    public static void main(String[] args) {
        // Library 객체 생성
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        // 기본 데이터 추가
        addTestBooks(libraryManager);

        boolean running = true;
        while (running) {
            try {
                displayMenu();
                System.out.println("메뉴를 선택하세요.");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("=== 전체 도서 목록 조회 ===");
                        printBookList(libraryManager.getAllBooks());
                        System.out.println("1. 출판년도순으로 보기");
                        System.out.println("2. 제목순으로 보기");
                        System.out.println("3. 가격순으로 보기");
                        System.out.println("4. 메뉴로 돌아가기");
                        System.out.println("정렬 기준을 선택하세요.");
                        switch (scanner.nextInt()) {
                            case 1:
                                printBookList(libraryManager.getSortedBooksByYear());
                                break;
                            case 2:
                                printBookList(libraryManager.getSortedBooksByTitle());
                                break;
                            case 3:
                                printBookList(libraryManager.getSortedBooksByPrice());
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
                        }
                        break;
                    case 2:
                        System.out.println("=== 도서 검색하기 ===");
                        System.out.println("1. 제목으로 검색하기");
                        System.out.println("2. 저자명으로 검색하기");
                        System.out.println("검색 기준을 선택하세요.");
                        int searchBy = scanner.nextInt();
                        System.out.println("검색어를 입력하세요.");
                        String search = scanner.next();
                        switch (searchBy) {
                            case 1:
                                printBookList(libraryManager.searchBooksByTitle(search));
                                break;
                            case 2:
                                printBookList(libraryManager.searchBooksByAuthor(search));
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("=== 도서 대여하기 ===");
                        System.out.println("사용자 ID를 입력하세요.");
                        String borrowUserId = scanner.next();
                        System.out.println("대여할 도서의 ISBN을 입력하세요");
                        String borrowIsbn = scanner.next();
                        libraryManager.borrowBook(borrowUserId, borrowIsbn);
                        System.out.println("도서 대여 완료");
                        LocalDate borrowDate = LocalDate.now();
                        System.out.println("반납 기한: " + borrowDate.plusDays(14));
                        break;
                    case 4:
                        System.out.println("=== 도서 반납하기 ===");
                        System.out.println("사용자 ID를 입력하세요.");
                        String returnUserId = scanner.next();
                        System.out.println("반납할 도서의 ISBN을 입력하세요.");
                        String returnIsbn = scanner.next();
                        libraryManager.returnBook(returnUserId, returnIsbn);
                        System.out.println("도서 반납 완료");
                        break;
                    case 5:
                        System.out.println("=== 도서 추가하기 ===");
                        System.out.println("추가할 도서의 ISBN: ");
                        String addIsbn = scanner.next();
                        System.out.println("추가할 도서의 제목: ");
                        String addTitle = scanner.next();
                        System.out.println("추가할 도서의 저자명: ");
                        String addAuthor = scanner.next();
                        System.out.println("추가할 도서의 가격: ");
                        int addPrice = scanner.nextInt();
                        System.out.println("추가할 도서의 출판년도: ");
                        int addYear = scanner.nextInt();
                        System.out.println("추가할 도서의 카테고리: ");
                        String addCategory = scanner.next();

                        Book addBook = new Book(addIsbn, addTitle, addAuthor, addCategory, addYear, addPrice);
                        libraryManager.addBook(addBook);
                        System.out.println("도서가 추가되었습니다.");
                        break;
                    case 6:
                        System.out.println("=== 나의 대여 도서 목록 조회 ===");
                        System.out.println("사용자 ID를 입력하세요.");
                        String userId = scanner.next();
                        printBookList(libraryManager.getBorrowedBooks(userId));
                        break;
                    case 7:
                        System.out.println("=== 카테고리 별 도서 목록 조회 ===");
                        System.out.println("전체 카테고리");
                        System.out.println(libraryManager.getCategories());
                        System.out.println("조회할 카테고리명을 입력하세요.");
                        String category = scanner.next();
                        printBookList(libraryManager.getBooksByCategory(category));
                        break;
                    case 0:
                        running = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (NumberFormatException e){
                    System.out.println("오류: 숫자를 입력하세요.");
            } catch (Exception e) {
                System.out.println("시스템 오류: "+e.getMessage());
            }
        }
    }

    /**
     * 도서 출력 메소드
     * @param books
     */
    private static void printBookList(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("도서가 없습니다.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * 기본 데이터 추가 메소드
     */
    private static void addTestBooks(LibraryManager manager) {
        manager.addBook(new Book("9788960777330", "자바 프로그래밍", "홍작가", "프로그래밍", 2021, 30000));
        manager.addBook(new Book("9788960777347", "파이썬 기초", "김작가", "프로그래밍", 2020, 25000));
        manager.addBook(new Book("9788960777354", "알고리즘 개론", "이작가", "컴퓨터과학", 2019, 35000));
        manager.addBook(new Book("9788960777361", "자바스크립트 완벽 가이드", "박작가", "프로그래밍", 2022, 28000));
        manager.addBook(new Book("9788960777378", "인공지능 입문", "정지원", "컴퓨터과학", 2021, 40000));
        manager.addBook(new Book("9788960777385", "데이터베이스 시스템", "김작가", "컴퓨터과학", 2018, 32000));
        manager.addBook(new Book("9788960777392", "웹 개발의 정석", "이작가", "프로그래밍", 2023, 27000));
        manager.addBook(new Book("9788960777408", "리눅스 프로그래밍", "한작가", "프로그래밍", 2020, 26000));
        manager.addBook(new Book("9788960777415", "네트워크 보안", "김작가", "컴퓨터네트워크", 2022, 38000));
        manager.addBook(new Book("9788960777422", "클라우드 컴퓨팅", "정작가", "컴퓨터시스템", 2021, 36000));
    }
}
