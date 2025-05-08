package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    ArrayList<Buyable> products;
    
    // TODO: 생성자 정의
    public ShoppingCart(){
        this.products = new ArrayList<>();
    }
    
    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addProduct(Buyable product) {
        System.out.println("장바구니에 추가되었습니다.");
        this.products.add(product);
    }
    
    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeProduct(Buyable product) {
        System.out.println("장바구니에서 제거되었습니다.");
        this.products.remove(product);
    }
    
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public int totalPrice(){
        int sum = 0;
        for (Buyable p:products) {
            sum += p.getPrice();
        }
        return sum;
    }
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void shoppingCartList(){
        System.out.println("== 장바구니 상품 리스트 ==");
        for(Buyable p:products){
            p.getInfo();
        }
    }
} 