package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 * 
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte a = 1;
        short b = 2220;
        int c = 10000;
        long d = 2570257;
        
        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float e = 3.14f;
        double f = 5.3425;
        
        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char g = 'G';
        
        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean h = true;
        
        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println(""+ a + '\n' + b + '\n' + c + '\n' + d + '\n' + e + '\n' + f + '\n' + g +'\n' + h);

        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        double tall = 1.75;
        int weight = 56;
        double bmi = weight/(tall*tall);
        System.out.println(bmi);
    }
} 