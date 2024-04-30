package calculator;

import java.util.ArrayList;
import calculator.BadInputException;

public class Calculator {
    private ArrayList<String> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char operator) throws BadInputException {
        int result = 0;
        try {
            switch (operator) {
                case '+': result = num1 + num2;
                    break;
                case '-': result = num1 - num2;
                    break;
                case '*': result = num1 * num2;
                    break;
                case '/':
                    try { // try-catch 문으로 나눗셈 연산 예외 처리
                        result = num1 / num2;
                    } catch (ArithmeticException e) {
                        throw new BadInputException("0으로 나누기");
                    }
                    break;
                default:
                    throw new BadInputException("올바른 연산자를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new BadInputException(e.getMessage());
        }
        return result;
    }
}
