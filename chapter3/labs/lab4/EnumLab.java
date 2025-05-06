package chapter3.labs.lab4;

import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();
        
        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        enum DayOfWeek {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
        DayOfWeek today = DayOfWeek.valueOf(input.toUpperCase());
        System.out.println("오늘: " + today);

        switch (today){
            case SATURDAY: case SUNDAY:
                System.out.println("주말입니다.");
                break;
            default:
                System.out.println("평일입니다.");
                break;
        }

        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();
        
        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.
        enum Season {
            SPRING("내가 태어난 계절", 15),
            SUMMER("너무 덥고 모기 많아 ㅠ", 30),
            FALL("시원하고 단풍 예쁨", 14),
            WINTER("크리스마스~~", -10);
            // 필드 설정
            private final String description;
            private final int averageTemp;

            // 생성자
            Season(String description, int averageTemp){
                this.description = description;
                this.averageTemp = averageTemp;
            }

            public String getDescription() {
                return description;
            }
            public int getAverageTemp() {
                return averageTemp;
            }
        }
        switch (month) {
            case 12: case 1: case 2:
                System.out.println("계절: 겨울");
                System.out.println(Season.WINTER.getDescription());
                System.out.println("평균 기온: "+Season.WINTER.getAverageTemp());
                break;
            case 3: case 4: case 5:
                System.out.println("계절: 봄");
                System.out.println(Season.SPRING.getDescription());
                System.out.println("평균 기온: "+Season.SPRING.getAverageTemp());
                break;
            case 6: case 7: case 8:
                System.out.println("계절: 여름");
                System.out.println(Season.SUMMER.getDescription());
                System.out.println("평균 기온: "+Season.SUMMER.getAverageTemp());
                break;
            case 9: case 10: case 11:
                System.out.println("계절: 가을");
                System.out.println(Season.FALL.getDescription());
                System.out.println("평균 기온: "+Season.FALL.getAverageTemp());
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

        
        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");
        
        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.
        enum TaskStatus {
            PENDING{
                @Override
                public TaskStatus next(){return IN_PROGRESS;}
            },
            IN_PROGRESS{
                @Override
                public TaskStatus next(){return COMPLETED;}
            },
            COMPLETED{
                @Override
                public TaskStatus next(){return ARCHIVED;}
            },
            ARCHIVED{
                @Override
                public TaskStatus next(){return PENDING;}
            };

            public abstract TaskStatus next();
        }

        TaskStatus status = TaskStatus.PENDING;
        do {
            System.out.println("다음 단계로: next");
            System.out.println("종료: exit");
            System.out.println("현재 상태: "+status);
            String cmd = scanner.next();
            if (cmd.equals("next")) {
                status = status.next();
            } else if (cmd.equals("exit")) {
                System.out.println("종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } while (true);

        
        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기
        
        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.

        enum Operator {
            ADD("+"){
                @Override
                public int calculate(int x, int y) {
                    return x+y;
                }
            },
            SUBTRACT("-") {
                @Override
                public int calculate(int x, int y) {
                    return x-y;
                }
            },
            MULTIPLY("*") {
                @Override
                public int calculate(int x, int y) {
                    return x*y;
                }
            },
            DIVIDE("/"){
                @Override
                public int calculate(int x, int y) {
                    return x/y;
                }
            };

            private final String symbol;
            Operator(String symbol){this.symbol = symbol;}
            @Override
            public String toString() {return symbol;}
            public abstract int calculate(int x,int y);
        }
        System.out.println("연산을 수행할 첫번째 숫자를 입력하세요:");
        int x = scanner.nextInt();
        System.out.println("연산을 수행할 두번째 숫자를 입력하세요:");
        int y = scanner.nextInt();
        try {
            System.out.println("어떤 연산을 수행할까요?(ADD/SUBSTRACT/MULTIPLY/DIVIDE):");
            Operator op = Operator.valueOf(scanner.next().toUpperCase());
            System.out.println(x+" "+op+" "+y+" = "+op.calculate(x, y));
        } catch (IllegalArgumentException e){
            System.out.println("잘못된 연산입니다.");
        }

        scanner.close();
    }
} 