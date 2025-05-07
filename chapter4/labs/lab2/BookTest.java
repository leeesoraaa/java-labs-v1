package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");
        
        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book1 = new Book();
        book1.getInfo();
        System.out.println();
        
        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book2 = new Book("AWS 클라우드 활용");
        book2.getInfo();
        System.out.println();
        
        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book3 = new Book("MSA 기반", "이소라");
        book3.getInfo();
        System.out.println();
        
        
        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book4 = new Book("Java 개발자", "Java master", 10000);
        book4.getInfo();
        System.out.println();
        
        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book5 = new Book("새싹 영등포캠 7기","국제인재능력개발원", 200000, 2025);
        book5.getInfo();
        System.out.println();
        
        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        Book book6 = new Book("청년취업사관학교", "이소라", 50000, 2024);
        book6.author = "저자 미상";
        book6.getInfo();
        
    }
} 