package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Driver 클래스 정의하기 (Car를 사용하는 관계)
 */
public class Driver {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (이름, 운전 경력 등)
    private String name;
    private int driveYear;
    
    
    // TODO: 생성자를 정의하세요.
    public Driver(String name, int driveYear) {
        this.name = name;
        this.driveYear = driveYear;
    }
    
    
    // TODO: 자동차를 운전하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void drive(Car car){
        System.out.println(name + "님이 운전중입니다.");
        car.startCar();
        car.faster(100);
    }
    
    
    // TODO: 자동차를 점검하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void checkCar(Car car){
        System.out.println(name + "님이 자동차를 점검중입니다.");
        car.getCarInfo();
    }
    
    
    // TODO: 운전자의 정보를 출력하는 메소드를 정의하세요.
    public void getDriverInfo(){
        System.out.println("이름: "+name+"운전 경력: "+driveYear);
    }
    
} 