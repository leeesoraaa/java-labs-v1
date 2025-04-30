package chapter3.labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 활용하기 실습
 */
public class ArrayLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 정수형 배열 활용
        System.out.println("===== 정수형 배열 활용 =====");
        
        // TODO: 5개의 정수를 입력받아 배열에 저장하고, 합계와 평균을 계산하여 출력하세요.
        // 힌트: Scanner를 이용하여 사용자로부터 입력을 받으세요.
        int[] numbers = new int[5];
        for (int i = 0; i <5; i++){
            System.out.print("정수를 입력하세요:");
            numbers[i] = scanner.nextInt();
        }
        int count = 0;
        for (int num : numbers){
            count += num;
        }
        System.out.println("합계: "+count);
        System.out.println("평균: "+count/numbers.length +'.'+count%numbers.length);

        // 2. 문자열 배열 활용
        System.out.println("\n===== 문자열 배열 활용 =====");
        
        // TODO: 5개의 이름을 입력받아 배열에 저장하고, 특정 문자(예: 'A')로 시작하는 이름을 검색하여 출력하세요.
        // 힌트: String 클래스의 startsWith() 또는 charAt() 메소드를 활용하세요.
        System.out.println("쉼표로 구분해 이름 5개를 입력하세요");
        String[] names = scanner.next().split(",");

        System.out.println("A로 시작하는 이름:");
        for (String name:names){
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
        // 3. 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");
        
        // TODO: 사용자로부터 5개의 정수를 입력받아 배열에 저장한 후, 오름차순으로 정렬하여 출력하세요.
        // 힌트: 이중 반복문을 사용하여 버블 정렬 알고리즘을 구현하거나, Arrays.sort()를 활용하세요.
        int[] numbers2 = new int[5];
        for (int i=0; i<5; i++){
            System.out.print("정수를 입력하세요:");
            numbers2[i] = scanner.nextInt();
        }

        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++) {
                if (numbers2[i] < numbers2[j]) {
                    int numI = numbers2[i];
                    int numJ = numbers2[j];
                    numbers2[j] = numI;
                    numbers2[i] = numJ;
                }
            }
        }
        System.out.println("정렬된 배열: " + Arrays.toString(numbers2));
        
        // 4. 2차원 배열을 이용한 행렬 덧셈
        System.out.println("\n===== 2차원 배열을 이용한 행렬 덧셈 =====");
        
        // TODO: 두 개의 2x3 행렬을 입력받아 행렬 덧셈을 수행하고 결과를 출력하세요.
        // 힌트: 중첩 반복문을 사용하세요.
        String[][] matrixA = makeMatrix(2,3);
        String[][] matrixB = makeMatrix(2,3);
        int[][] matrixC = new int[2][3];
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                matrixC[i][j] = Integer.parseInt(matrixA[i][j]) + Integer.parseInt(matrixB[i][j]);
            }
        }
        for (int i=0; i<2; i++){
            System.out.println(Arrays.toString(matrixC[i]));
        }


        // 5. 배열을 이용한 간단한 데이터 분석
        System.out.println("\n===== 배열을 이용한 데이터 분석 =====");
        
        // TODO: 10개의 정수를 입력받아 배열에 저장한 후, 최댓값, 최솟값, 중앙값(또는 평균)을 계산하여 출력하세요.
        // 힌트: 정렬을 활용하면 중앙값을 쉽게 찾을 수 있습니다.
        System.out.print("쉼표로 구분해 정수 10개를 입력하세요:");
        String[] strings10 = scanner.next().split(",");
        int[] numbers10 = new int[10];
        for (int i=0; i<10; i++){
            numbers10[i] = Integer.parseInt(strings10[i]);
        }
        Arrays.sort(numbers10);
        System.out.println("최댓값: "+numbers10[numbers10.length-1]);
        System.out.println("최솟값: "+numbers10[0]);
        System.out.println("중앙값: "+(numbers10[4]+numbers10[5])/2 +'.'+(numbers10[4]+numbers10[5])%2);

        scanner.close();
    }

    // matrix 만드는 메서드
    public static String[][] makeMatrix(int row, int col) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[row][];
        for (int i=0; i<row; i++) {
            System.out.println(i+"번째 행의 숫자들을 쉼표(,)로 구분하여 입력하세요.");
            matrix[i] = scanner.next().split(",");
        }
        scanner.close();
        return matrix;
    }

} 