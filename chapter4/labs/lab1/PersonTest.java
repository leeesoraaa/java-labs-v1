package chapter4.labs.lab1;

import java.time.LocalDate;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스를 테스트하는 메인 클래스
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("Person 클래스 테스트를 시작합니다.");
        
        // TODO: 이름이 John, 나이가 20, 성별이 Male인 Person 객체를 생성하세요.
        Person person1 = new Person();
        person1.name = "John";
        person1.age = 20;
        person1.gender = "Male";
        person1.birth = LocalDate.of(2005, 03, 15);
        
        // TODO: 생성한 객체의 정보를 출력하세요.
        person1.getInfo();
        System.out.println();
        
        // TODO: 생일이 지나 나이가
        person1.birthday();
        System.out.println();
        
        // TODO: 이름이 Emily, 나이가 25, 성별이 Female인 두 번째 Person 객체를 생성하세요.
        Person person2 = new Person();
        person2.name = "Emily";
        person2.age = 25;
        person2.gender = "Female";
        person2.birth = LocalDate.of(2001, 05, 02);
        
        // TODO: 두 번째 객체의 정보를 출력하세요.
        person2.getInfo();
        
        // TODO: 두 번째 객체의 나이를 증가시키고 정보를 다시 출력하세요.
        person2.birthday();
        person2.getInfo();
        // TODO: 추가로 여러 Person 객체를 생성하여 배열로 관리하고 모든 객체의 정보를 출력하세요.
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = new Person();
        people[2].name = "이소라";
        people[2].age = 23;
        people[2].gender = "Female";
        people[2].birth = LocalDate.of(2001,05,27);
        for(Person p: people) {
            p.getInfo();
            System.out.println();
        }
        
    }
} 