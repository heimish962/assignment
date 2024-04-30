package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) { // 반환값이 없어서 void
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (BadInputException e) {
                System.out.println("오류: " + e.getMessage());
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, inquiry 입력 시 저장된 연산 결과 출력): ");
            String input = sc.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break; // 무한 루프 종료
            } else if (input.equals("inquiry")) { // 추가 조건으로 "inquiry"를 넣어 줬고 향상된 for문으로 res라는 결괏값을 출력.
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                for (int res : calculator.getResults()) { // getResults() 메서드로 저장된 연산결과 가져오기
                    System.out.println(res);
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료): ");
            input = sc.next();
            // input이 "exit"이면 종료
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break; // 무한 루프 종료
            }
        }
    }
}