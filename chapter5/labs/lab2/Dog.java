package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * Dog 클래스를 정의하세요.
 * 이 클래스는 Animal 추상 클래스를 상속받아야 합니다.
 */
public class Dog extends Animal {
    // TODO: 강아지의 추가 속성 정의 (예: 품종)
    private String kind;
    
    // TODO: 생성자 정의
    public Dog(String kind) {
        super();
        this.kind = kind;
    }
    
    // TODO: 추상 메소드 sound() 구현

    @Override
    public void sound() {
        System.out.println("멍멍");
    }


    // TODO: 필요한 경우 부모 클래스의 메소드 오버라이딩
    @Override
    public void getInfo(){
        System.out.println("강아지의 정보");
        super.getInfo();
        System.out.println("품종: "+kind);
    }
    
    // TODO: 강아지만의 고유한 메소드 추가
    public void walk(String where){
        System.out.println(getName() + "이는"+where+"산책중");
    }
} 