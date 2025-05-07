package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    public static final double PI = 3.14;
    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    public final int A;
    
    // TODO: 생성자를 정의하세요.
    public FinalExample(int a) {
        // final 변수 초기화
        this.A = a;
    }
    
    // TODO: final 메소드를 정의하세요.
    public final void finalMethod(){
        System.out.println("오버라이딩 할 수 없는 메서드");
    }
    
    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    public void receiveFinal(final int A){
        System.out.println("변경할 수 없는 변수: "+A);
    }
    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample fe = new FinalExample(5);
        
        // TODO: 객체의 메소드를 호출하세요.
        fe.finalMethod();
        fe.receiveFinal(5);
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        FinalClass fc = new FinalClass();
        fc.info();
        
        // TODO: final 지역 변수를 선언하고 사용하세요.
        System.out.println(fe.A);
        // fe.A = 4; //final 변수 변경 불가
        
    }
}

// TODO: final 클래스를 정의하세요.
final class FinalClass {
    public void info(){
        System.out.println("상속 불가 클래스");
    }
}

// class Cant extends FinalClass{} //final class 상속 불가

// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
class Parent{
    // final 메소드
    public final void finalMethod2(){
        System.out.println("오버라이딩 안 됨");
    }
    public void canOverride(){
        System.out.println("오버라이딩 가능");
    }
}
class Child extends Parent{
    @Override
    public void canOverride(){
        System.out.println("진짜 되네");
    }
    // finalMethod2는 오버라이딩 불가

}