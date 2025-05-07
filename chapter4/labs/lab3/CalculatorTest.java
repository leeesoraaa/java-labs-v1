package chapter4.labs.lab3;

import chapter4.labs.lab3.Calculator;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * Calculator 클래스를 테스트하는 메인 클래스
 */
public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Calculator 클래스 테스트를 시작합니다.");
        
        // TODO: 클래스 이름으로 static 상수에 접근하여 출력하세요.
        System.out.println(Calculator.PI);
        
        // TODO: 객체 생성 없이 static 메소드를 호출하여 원의 면적과 둘레를 계산하세요.
        double circleArea = Calculator.calculateCircleArea(4.0);
        double circleLine = Calculator.calculateCircleLine(4.0);
        System.out.println("원의 면적: "+circleArea);
        System.out.println("원의 둘레: "+circleLine);

        
        // TODO: 객체 생성 없이 static 메소드를 호출하여 사각형의 면적을 계산하세요.
        double squareArea = Calculator.calculateSquareArea(2.0,4.0);
        System.out.println("사각형의 면적: "+squareArea);
        
        // TODO: Calculator 객체를 생성하고 인스턴스 메소드를 호출하세요.
        Calculator calculator1 = new Calculator("calA");
        calculator1.calCount();
        
        // TODO: 생성된 Calculator 객체의 정보를 출력하세요.
        calculator1.getInfo();
        
        // TODO: 추가로 Calculator 객체를 생성하고, 객체 생성 횟수를 확인하세요.
        Calculator calculator2 = new Calculator("calB");
        System.out.println(Calculator.calculatorCount());
        
        // TODO: 각 객체의 인스턴스 변수 값과 static 변수 값을 비교하세요.
        calculator1.getInfo();
        calculator2.getInfo();
        System.out.println("총 계산기 수: "+Calculator.calculatorCount());
        System.out.println("PI = "+Calculator.PI);
        
    }
} 