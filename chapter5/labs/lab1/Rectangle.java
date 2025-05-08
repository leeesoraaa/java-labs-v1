package chapter5.labs.lab1;

/**
 * Lab 1: 상속과 메소드 오버라이딩
 * 
 * Rectangle 클래스를 정의하세요.
 * 이 클래스는 Shape 클래스를 상속받아야 합니다.
 */
public class Rectangle extends Shape {
    // TODO: 사각형의 속성 정의 (예: 너비, 높이)
    private double width;
    private double height;
    
    // TODO: 생성자 정의
    public Rectangle(String name, String color, double width, double height) {
        super(color, name);
        this.width = width;
        this.height = height;
    }
    
    // TODO: 부모 클래스의 메소드를 오버라이딩하여 사각형의 면적을 계산하는 메소드 구현
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    // TODO: 부모 클래스의 메소드를 오버라이딩하여 사각형 정보를 출력하는 메소드 구현
    @Override
    public void getInfo(){
        System.out.println("사각형 정보");
        super.getInfo();
        System.out.println("넓이: "+width);
        System.out.println("높이: "+height);
    }
}