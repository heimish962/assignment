package calculator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>(); // ArrayList로 연산결과 저장
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
            results.add(result); // 연산 결과 리스트에 추가

            System.out.println("결과: " + result);

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 종료): ");
            String input = sc.next();
            /* 두 객체를 비교하는 Objects.equals로 input(String타입)이 "remove"이면 결괏값이 중첩 if문으로 비어있는지 확인 */
            if (Objects.equals(input,"remove")) {
                if (results.isEmpty()) {
                    System.out.println("삭제할 결과가 없습니다.");
                } else {
                    int removedResult = results.remove(0); // 가장 먼저 저장된 결과 삭제
                    System.out.println("removedResult = " + removedResult);
                }
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료): ");
                input = sc.next();
                if (Objects.equals(input,"exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break; // 무한 루프 종료
                }
            }
        }
        sc.close(); // 스캐너 닫기
    }
}