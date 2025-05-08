package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * 여러 동물 객체를 생성하고, 각 동물의 정보와 소리를 출력하는 테스트 클래스입니다.
 */
public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("Lab 2: 추상 클래스 활용하기 실습");
        
        // TODO: Dog 객체 생성
        Dog dog = new Dog("말티즈");
        dog.setAge(7);
        dog.setName("초롱이");

        // TODO: Cat 객체 생성
        Cat cat = new Cat("black");
        cat.setAge(3);
        cat.setName("루시");

        // TODO: Bird 객체 생성
        Bird bird = new Bird(10, "참새");
        bird.setAge(5);
        bird.setName("짹짹이");

        Animal animal = bird;
        // TODO: 각 동물의 정보와 소리 출력
        dog.sound();
        cat.sound();
        bird.sound();
        animal.sound();

        // animal.fly(); 불가능  형변환 필요
        ((Bird)animal).fly();
        //((Dog)animal).walk(); 불가능 현재 animal은 bird로 정의되어 있기 때문에

        // TODO: 배열을 사용하여 여러 Animal 객체 관리하기
        Animal[] animals = new Animal[3];
        animals[0] = dog;
        animals[1] = cat;
        animals[2] = bird;
        // TODO: 모든 동물에 대해 반복하여 정보와 소리 출력하기
        for(Animal a:animals) {
            a.getInfo();
            a.sound();
        }
        dog.walk("공원");
        cat.eat();
        bird.fly();
    }
} 