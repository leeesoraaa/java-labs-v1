package chapter3.labs.lab5;

import java.util.*;


/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.
    enum Grade{
        A(90, 100),
        B(80, 89),
        C(70, 79),
        D(60, 69),
        F(0, 59);

        private final int minScore;
        private final int maxScore;

        //생성자
        Grade(int minScore, int maxScore) {
            this.minScore = minScore;
            this.maxScore = maxScore;
        }

    }
    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.
                    System.out.print("이름:");
                    String name1 = scanner.next();
                    System.out.print("성적:");
                    int score = scanner.nextInt();
                    names[studentCount] = name1;
                    scores[studentCount] = score;
                    studentCount++;
                    System.out.println("저장되었습니다.");
                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    if (studentCount ==0){
                        System.out.println("성적표가 비어있습니다.");
                        break;
                    }
                    System.out.print("이름: ");
                    String name2 = scanner.next();
                    int idx2 = findByName(name2);
                    if (idx2 == -1){
                        System.out.println("존재하지 않는 이름입니다.");
                        break;
                    }
                    System.out.print("성적:");
                    scores[idx2] = scanner.nextInt();
                    System.out.println("변경되었습니다.");
                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    if (studentCount == 0){
                        System.out.println("성적표가 비어있습니다.");
                        break;
                    }
                    System.out.println("이름   성적    등급");
                    for (int i=0; i<studentCount; i++) {
                        Grade grade = getGrade(scores[i]);
                        System.out.println(names[i] + "   " + scores[i] + "   "+grade);
                    }
                    System.out.println();
                    System.out.println("전체 " + studentCount+"명  합계: "+allScoreSum()+"  평균: "+allScoreAvg());
                    System.out.println("최고 성적: "+getBest().getKey() +" "+getBest().getValue());
                    System.out.println("최저 성적: "+getWorst().getKey()+" "+getWorst().getValue());
                    
                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    if (studentCount == 0){
                        System.out.println("성적표가 비어있습니다.");
                        break;
                    }
                    System.out.print("이름: ");
                    String name4 = scanner.next();
                    int idx4 = findByName(name4);
                    int score4 = scores[idx4];
                    Grade grade4 = getGrade(score4);
                    System.out.println(score4 + "점 "+grade4 + "등급");
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    Map<Grade, Integer> gradeCount = gradeCount();
                    for (Grade g:Grade.values()){
                        int count = gradeCount.get(g);
                        double ratio = studentCount ==0 ? 0.0 : count*100.0/studentCount;
                        System.out.printf("%s등급: %d명 (%.1f%%)  ", g, count, ratio);
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.
    private static Grade getGrade(int score){
        for (Grade grade : Grade.values()) {
            if (grade.minScore <= score && score <= grade.maxScore) {
                return grade;
            }
        }
        return Grade.F;
    }
    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    private static int allScoreSum() {
        return Arrays.stream(scores,0,studentCount).sum();
    }
    
    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static Double allScoreAvg() {
        if (studentCount == 0) {
            return 0.0;
        }
        return (double)allScoreSum()/studentCount;
    }
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    private static Map.Entry<String, Integer> getBest() {
        int bestScore = scores[0];
        String topName = names[0];
        for (int i=0; i<studentCount;i++){
            if (scores[i] > bestScore) {
                bestScore = scores[i];
                topName = names[i];
            }
        }
        return new AbstractMap.SimpleEntry<>(topName, bestScore);
    }
    
    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    private static Map.Entry<String, Integer> getWorst() {
        int worstScore = scores[0];
        String bottomName = names[0];
        for (int i=0; i<studentCount; i++){
            if (scores[i] < worstScore) {
                worstScore = scores[i];
                bottomName = names[i];
            }
        }
        return new AbstractMap.SimpleEntry<>(bottomName, worstScore);
    }
    
    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    private static int findByName(String name){
        for (int i=0; i<studentCount;i++){
            if (names[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    // TODO: 등급별 학생 수를 찾는 메서드를 구현하세요.
    private static Map<Grade, Integer> gradeCount(){
        Map<Grade, Integer> gradeCount = new EnumMap<>(Grade.class);
        for (Grade g: Grade.values()){
            gradeCount.put(g, 0);
        }
        for (int i=0; i<studentCount; i++){
            Grade grade = getGrade(scores[i]);
            gradeCount.put(grade, gradeCount.get(grade)+1);
        }
        return gradeCount;
    }
    
} 