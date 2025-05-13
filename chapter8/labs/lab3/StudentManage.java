package chapter8.labs.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentManage {
    public static void main(String[] args) {
        // 자바 입문 책 셀프체크 334p
        // 1. ArrayList 클래스로 리스트를 생성하고 학생 이름을 추가하고 학생 명단 출력하기
        ArrayList<String> students = new ArrayList<>();
        students.add("홍길동");
        students.add("김길벗");
        students.add("이코천");
        students.add("홍길동");
        System.out.println(students);

        // 2. ArrayList 클래스로 생성한 리스트를 바탕으로 HashSet클래스의 객체를 생성해 학생 명단을 저장
        HashSet<String> studentsSet = new HashSet<>(students);

        // 3. HashSet에 '강남순' 학생 추가 후 학생 명단 출력
        studentsSet.add("강남순");
        System.out.println(studentsSet);

        // 4. HashMap 클래스로 맵을 만들고 학생 점수와 이름을 저장, 학생 이름별 점수 출력
        HashMap<String, Integer> studentsMap = new HashMap<>();
        studentsMap.put("홍길동", 85);
        studentsMap.put("김길벗", 92);
        studentsMap.put("이코천", 78);
        studentsMap.put("강남순", 90);
        System.out.println(studentsMap);
    }

}
