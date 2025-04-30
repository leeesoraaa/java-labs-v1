package chapter2._livecode;

public class Car {

    // 필드(속성)
    public String model;

    // 메서드
    public void printModel() {
        System.out.println(model);
    }

    // model 초기화 생성자
    private Car(String model) {
        this.model = model;
    } // private는 같은 클래스내에서만 호출 가능
    //다른 클래스에서 호출하면 생성 안 된다.

    // 기본 생성자
    public Car() {

    }

    public static void main(String[] args) {
        Car car = new Car("gv80");
        car.model = "ray";
        car.printModel();
    }
}
