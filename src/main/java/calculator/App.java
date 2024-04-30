package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] results = new int[10]; // 크기가 10인 정수 배열을 new 키워드로 생성
        int count = 0; // 연산 결과를 저장할 때 변수 초기화(저장된 연산결과 개수 추적) index=count

        // 무한루프를 위해 while (true)로 항상 참일 때 연산
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            int result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    // num2는 0이 될 수 없다는 조건 추가
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue; // continue 로 다음 반복으로 이동
                    }
                    break;
                default:
                    System.out.println("올바른 연산자를 입력하세요.");
                    continue; // continue 로 다음 반복으로 이동
            }
            System.out.println("결과: " + result);

            /* 연산 결과가 10개를 초과하는 경우 */
            if (count == results.length) {
                // 가장 먼저 저장된 결과 삭제
                for (int i=0; i<results.length -1; i++) {
                    results[i] = results[i+1]; // 앞으로 한칸씩 이동
                } results[count - 1] = result; // 새로운 결괏값 마지막 인덱스에 저장
            } else {
                results[count] = result;
                count++; // index = count 증가
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String input = sc.next();
            // 두 객체를 비교하는 Objects.equals로 input(String타입)이 "exit"이면 sout띄우고 break로 무한루프 나오기
            if (Objects.equals(input,"exit")) {
                System.out.println("프로그램을 종료합니다.");
                break; // 무한 루프 종료
            }
        }
        sc.close(); // 스캐너 닫기
    }
}