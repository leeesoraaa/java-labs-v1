package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte a = 4;
        int a2 = a;
        System.out.println(a2);
        long a3 = a2;
        System.out.println(a3);
        float a4 = a3;
        System.out.println(a4);
        double a5 = a4;
        System.out.println(a5);
        
        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기
        double b = 3.14;
        float b2 = (float) b;
        System.out.println(b2);
        long b3 = (long) b2;
        System.out.println(b3);
        int b4 = (int) b3;
        System.out.println(b4);
        char b5 = (char) b4;
        System.out.println(b5);
        short b6 = (short) b5;
        System.out.println(b6);
        byte b7 = (byte) b6;
        System.out.println(b7);
        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기
        int c = 300;
        byte c2 = (byte) c;
        System.out.println("int:" + c);
        System.out.println("byte:" + c2);
        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기
        String d = "123";
        int d2 = Integer.parseInt(d);
        System.out.println("String:" + d);
        System.out.println("int:"+ d2);

        String e = "3.14";
        double e2 = Double.parseDouble(e);
        System.out.println("String:" + e);
        System.out.println("double:"+ e2);
        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기
        int f = 456;
        String f2 = String.valueOf(f);
        System.out.println("int:" + f);
        System.out.println("String:" + f2);

        double g = 7.89;
        String g2 = String.valueOf(g);
        System.out.println("double:" + g);
        System.out.println("String:" + g2);
    }
} 