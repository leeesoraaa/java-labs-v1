package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private String engineType;
    private boolean running;
    
    
    // TODO: 생성자를 정의하세요.
    public Engine(String engineType){
        this.engineType = engineType;
        this.running = false;
    }
    
    
    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void startCar(){
        if(running) {
            System.out.println("Engine is already running");
        } else {
            running = true;
            System.out.println("Engine is starting");
        }
    }
    
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stopCar(){
        System.out.println("Engine is stopping car");
    }
    
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public void checkEngineStatus() {
        if (running) {
            System.out.println("시동이 걸려있습니다.");
        } else {
            System.out.println("시동이 꺼져있습니다.");
        }
    }
    
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
    public void getEngineInfo() {
        System.out.println("Engine Type: " + engineType + "  Running: "+ running);
    }
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}