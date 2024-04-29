package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
