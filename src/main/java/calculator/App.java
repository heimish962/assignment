package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num2 = sc.nextInt();

        System.out.println("사칙연산 기호를 입력하세요. : ");
        // 입력값을 chat 타입으로 변경.
        char operator = sc.next().charAt(0);

        int result = 0;
        // 연산자를 switch case 문으로 나누고 이 연산자들이 아닌 다른 걸 입력하면 default 로 0출력
            result = switch(operator) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> 0;
            };
        System.out.println("결과: " + result);
    }
}
