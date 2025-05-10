package chapter8.labs.lab1;

import chapter8.examples.ex1.Box;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 *
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");
        
        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> intStringPair = PairUtils.createPair(1,"안녕하세요.");
        System.out.println(intStringPair);

        // Double과 Double 타입의 Pair
        Pair<Double, Double> doubleDoublePair = PairUtils.createPair(1.0,2.0);
        System.out.println(doubleDoublePair);

        // 사용자 정의 클래스를 사용한 Pair
        Pair<Box, Box> boxBoxPair = PairUtils.createPair("이소라", 175);
        System.out.println(boxBoxPair);
        
        System.out.println("\n=== PairUtils 클래스 테스트 ===");
        
        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // isSame 메소드 테스트
        System.out.println("intStringPair = boxBoxPair: "+PairUtils.isSame(intStringPair, boxBoxPair));

        Pair<String, Integer> pair1 = new Pair<>("key1", 1);
        Pair<String, Integer> pair2 = new Pair<>("key1", 2);
        System.out.println("pair1 = pair2: "+PairUtils.isSame(pair1, pair2));

        // swap 메소드 테스트
        Pair swapPair = PairUtils.swap(intStringPair);
        System.out.println("swapPair: " +swapPair);

        // 숫자 타입의 sum 메소드 테스트
        Pair<Integer, Double> intDoublePair = PairUtils.createPair(5, 90.9);
        System.out.println("sum(Pair): "+PairUtils.sumKV(intDoublePair));

        // 타입 제한 테스트 (Number 하위 클래스만 가능)
        System.out.println("== 타입 제한 테스트(NUmber 하위 클래스만 가능 ==");
        System.out.println("PairUtils.sumKV(boxBoxPair); // error");
        
        // 와일드카드 메소드 테스트
        List<Pair> pairs = new ArrayList<>();
        pairs.add(intStringPair);
        pairs.add(doubleDoublePair);
        pairs.add(boxBoxPair);
        pairs.add(intDoublePair);
        PairUtils.printPair(pairs);
    }
} 