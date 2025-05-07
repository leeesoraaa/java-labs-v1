package chapter4.labs.lab1;

import java.time.LocalDate;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스 정의하기
 */
public class Person {
    // TODO: 이름, 나이, 성별을 저장할 수 있는 필드를 정의하세요.
    String name;
    int age;
    String gender;
    LocalDate birth;
    
    // TODO: 객체 정보를 출력하는 메소드를 작성하세요.
    public void getInfo(){
        System.out.println("이름: "+name+"  나이: "+age+"  성별: "+gender+"  생년월일: "+birth);
    }
    
    
    // TODO: 생일이 지났을 때 나이를 한 살 증가시키는 메소드를 작성하세요.
    public void birthday(){
        LocalDate today = LocalDate.now();
        if (today.getMonthValue()>birth.getMonthValue()||
            today.getMonthValue() == birth.getMonthValue() && today.getDayOfMonth()>=birth.getDayOfMonth()
        ){
            age++;
            System.out.println("생일을 축하합니다. 현재 나이: "+age);
        }
    }
    
} 