package chapter5.labs.lab1;

/**
 * Lab 1: 상속과 메소드 오버라이딩
 * 
 * Shape 클래스를 정의하세요.
 * 이 클래스는 도형의 기본 속성과 면적을 계산하는 메소드를 가지고 있어야 합니다.
 */
public abstract class Shape {
    // TODO: 도형의 기본 속성 정의 (예: 이름, 색상)
    private String color;
    private String name;
    
    // TODO: 생성자 정의
    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }
    
    // TODO: 면적을 계산하는 메소드 정의
    public abstract double calculateArea();
    
    // TODO: 도형 정보를 출력하는 메소드 정의
    public void getInfo(){
        System.out.println("이름: "+name);
        System.out.println("색깔: "+color);
        System.out.printf("면적: %.2f", calculateArea());
    }
} 