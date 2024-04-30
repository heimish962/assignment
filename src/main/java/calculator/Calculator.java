package calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> results; // 연산 결과를 저장할 ArrayList 필드

    public Calculator() {
        this.results = new ArrayList<>(); // ArrayList 초기화
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
                    if (num2 == 0) {
                        throw new BadInputException("0으로 나눌 수 없습니다.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new BadInputException("올바른 연산자를 입력하세요.");
            }
        } catch (BadInputException e) {
            throw new BadInputException("0으로 나눌 수 없습니다.");
        }
        results.add(result); // 연산 결과를 ArrayList에 저장
        return result;
    }

    public ArrayList<Integer> getResults() {
        return results; // 저장된 연산 결과를 반환
    }
}
