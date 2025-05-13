package chapter7.labs.lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadTest {
    public static void main(String[] args) {
        // 자바입문 책 357P 셀프체크
        // 1. inputTest.txt 파일을 읽어와서 outputTest.txt파일에 저장하는 프로그램
        try (BufferedReader br = new BufferedReader(new FileReader("sora.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("sora 복사본.txt"))){
            System.out.println("sora.txt 파일을 읽어옵니다.");
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일이 성공적으로 복사되었습니다.");
        } catch (IOException e) {
            System.out.println("오류 발생: "+e.getMessage());
        }
    }
}
