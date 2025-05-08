package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Electronics 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Electronics implements Buyable {
    // TODO: 전자제품의 속성 정의 (예: 이름, 가격, 제조사)
    private String name;
    private int price;
    private String manufacture;
    private boolean working;
    private int buyYear;
    
    // TODO: 생성자 정의
    public Electronics(String name, int price, String manufacture, int buyYear) {
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
        this.working = true;
        this.buyYear = buyYear;
    }
    
    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getPrice(){
        return price;
    }
    
    // TODO: 전자제품만의 고유한 메소드 추가
    public void Fix() {
        if (working) {
            System.out.println("정상 작동됩니다.");
        } else {
            if (buyYear>2023) {
                System.out.println("무료로 수리해드립니다.");
            } else {
                System.out.println("수리비용: 150000원");
            }
        }
    }

    public void notworking() {
        if (working) {
            working = false;
            System.out.println("제품이 고장났습니다.");
        }
    }
} 