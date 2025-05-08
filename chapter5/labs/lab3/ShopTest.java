package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Buyable book1 = new Book("아무도 없는 바다", "최유수", 12000);
        
        // TODO: Electronics 객체 생성
        Buyable electron1 = new Electronics("화이트컬러 전자레인지", 50000, "LG 전자", 2024);
        
        // TODO: DiscountedBook 객체 생성
        Buyable DCbook1 = new DiscountedBook("자바 입문", "최원효", 20000);
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart shoppingCart1 = new ShoppingCart();
        
        // TODO: 장바구니에 상품 추가하기
        shoppingCart1.addProduct(book1);
        shoppingCart1.addProduct(electron1);
        shoppingCart1.addProduct(DCbook1);
        
        
        // TODO: 장바구니 내용과 총액 출력하기
        shoppingCart1.shoppingCartList();
        shoppingCart1.totalPrice();
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        Buyable[] items = {book1, electron1, DCbook1};
        for (Buyable item : items) {
            item.getInfo();
        }
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        System.out.println("=== 총 결제 금액 계산하기 ===");
        double totalPrice = 0;
        for (Buyable item:items) {
            System.out.println("상품명: "+item.getName()+",  가격: "+item.getPrice());
            if (item instanceof DiscountedBook) {
                System.out.println("해당 제품은 할인 품목입니다.");
                int DCpercent = ((DiscountedBook)item).getDiscountPercentage();
                double DCprice = ((DiscountedBook) item).getDiscountedPrice();
                System.out.println(DCpercent + "% 할인된 가격: "+DCprice);
                totalPrice += DCprice;
            } else {
                totalPrice += item.getPrice();
            }
        }
        System.out.println("총 결제 금액: "+totalPrice);
    }
} 