package chapter2.labs.lab4;

import java.util.Scanner;

/**
 * while 반복문을 사용한 반복 실습
 */
public class WhileLoopLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 사용자로부터 숫자를 입력받아 0이 입력될 때까지 합을 계산하여 출력하는 프로그램
        System.out.println("숫자를 입력하세요 (0을 입력하면 종료):");
        
        // TODO: 사용자로부터 숫자를 입력받고, 0이 입력될 때까지의 합계를 계산하여 출력하세요.
        // 1. 합계를 저장할 변수를 선언하세요.
        // 2. while 반복문을 사용하여 사용자로부터 숫자를 입력받으세요.
        // 3. 입력받은 숫자가 0이 아니면 합계에 더하고, 0이면 반복문을 종료하세요.
        // 4. 최종 합계를 출력하세요.
        int sum = 0;
        while (true){
            int num = scanner.nextInt();
            if (num == 0){
                break;
            } else {
                sum += num;
            }
        }
        System.out.println(sum);

        // 2. 1부터 100까지의 짝수만 출력하는 프로그램
        System.out.println("\n1부터 100까지의 짝수 출력:");
        
        // TODO: while 반복문을 사용하여 1부터 100까지의 짝수만 출력하세요.
        // 1. 변수를 1로 초기화하세요.
        // 2. while 반복문을 사용하여 변수가 100 이하인 동안 반복하세요.
        // 3. 변수가 짝수인 경우에만 출력하세요.
        // 4. 변수를 1씩 증가시키세요.
        int i = 1;
        while(i<=100){
            if (i%2==0){
                System.out.println(i);
            }
            i++;
        }

        
        // 3. 구구단 출력 (do-while 사용)
        System.out.println("\n출력할 구구단의 단을 입력하세요 (2-9): ");
        
        // TODO: do-while 반복문을 사용하여 사용자가 2-9 사이의 숫자를 입력할 때까지 반복하고,
        // 입력받은 단의 구구단을 출력하세요.
        int dan = 2;
        do {
            dan = scanner.nextInt();
            System.out.println(dan + "단");
            for (int j=1; j<=9; j++){
                System.out.println(dan + "*" + j + "=" + (dan*j));
            }
        } while (dan<2 || dan >9);
        
        // 4. 숫자 맞추기 게임
        System.out.println("\n숫자 맞추기 게임:");
        
        // 컴퓨터가 1에서 100 사이의 임의의 숫자를 선택 (예시로 73 사용)
        int targetNumber = 73;
        
        // TODO: while 반복문을 사용하여 사용자가 숫자를 맞출 때까지 반복하세요.
        // 1. 사용자로부터 숫자를 입력받으세요.
        // 2. 시도 횟수를 증가시키세요.
        // 3. 입력받은 숫자가 목표 숫자보다 크면 "더 작은 숫자를 입력하세요."를 출력하세요.
        // 4. 입력받은 숫자가 목표 숫자보다 작으면 "더 큰 숫자를 입력하세요."를 출력하세요.
        // 5. 입력받은 숫자가 목표 숫자와 같으면 "정답입니다!"와 시도 횟수를 출력하고 반복문을 종료하세요.
        int trycount = 1;
        while (true) {
            int number = scanner.nextInt();
            if (number == targetNumber) {
                System.out.println("정답입니다!");
                System.out.println("시도 횟수:" + trycount);
                break;
            } else if (number < targetNumber) {
                System.out.println("더 큰 숫자를 입력하세요.");
            } else {
                System.out.println("더 작은 숫자를 입력하세요.");
            }
            trycount++;
        }
        
        // 5. 피보나치 수열 출력하기
        System.out.println("\n피보나치 수열 출력:");
        System.out.println("출력할 피보나치 수열의 개수를 입력하세요: ");
        int count = scanner.nextInt();
        
        // TODO: while 반복문을 사용하여 입력받은 개수만큼 피보나치 수열을 출력하세요.
        // 피보나치 수열은 0, 1로 시작하며, 그 다음 숫자부터는 바로 앞의 두 숫자의 합입니다.
        // 예: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
        int realcount = 0;
        int a =0, b=1;
        while (realcount < count) {
            System.out.print(a +", ");
            int temp = a + b;
            a = b;
            b = temp;
            realcount ++;
        }
        
        scanner.close();
    }
} 