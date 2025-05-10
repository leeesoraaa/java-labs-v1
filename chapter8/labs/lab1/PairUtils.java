package chapter8.labs.lab1;

import java.util.List;

/**
 * Lab 1: 제네릭 유틸리티 클래스
 *
 * 다양한 제네릭 메소드를 포함한 유틸리티 클래스를 구현하세요.
 */
public class PairUtils {
    
    /**
     * 두 객체로 구성된 Pair 객체를 생성하는 정적 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static <T> Pair createPair(T ob1, T ob2) {
        return new Pair(ob1, ob2);
    }
    
    
    /**
     * Pair 객체의 키와 값을 바꾼 새로운 Pair 객체를 반환하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static Pair swap(Pair pair){
        return new Pair(pair.getValue(), pair.getKey());
    }
    
    /**
     * 숫자 타입의 Pair 객체에서 키와 값의 합을 계산하는 메소드
     * Number 또는 그 하위 클래스 타입만 허용
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static double sumKV(Pair<? extends Number, ? extends Number> pair) {
        double sum = 0.0;
        sum += pair.getKey().doubleValue() + pair.getValue().doubleValue();
        return sum;
    }
    
    /**
     * 두 Pair 객체를 비교하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static boolean isSame(Pair pair1, Pair pair2) {
        if (pair1.equals(pair2)&&pair1.hashCode()==pair2.hashCode()){
            return true;
        }
        return false;
    }
    
    
    /**
     * 리스트에서 조건에 맞는 요소로 구성된 Pair 객체를 찾는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */

    public static <T> Pair search(Pair[] pairs, T element) {
        for (Pair pair : pairs) {
            if (pair.getKey().equals(element)||pair.getValue().equals(element)){
                return pair;
            }
        }
        return null;
    }
    
    
    /**
     * 와일드카드를 사용하여 Pair 객체의 모든 가능한 타입을 처리하는 메소드
     * 
     * TODO: 메소드를 구현하세요.
     */
    public static void printPair(List<?> pairs){
        for (Object pair : pairs) {
            System.out.println(pair.toString());
        }
    }
} 