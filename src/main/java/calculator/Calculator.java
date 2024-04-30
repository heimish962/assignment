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
            throw new BadInputException("올바른 연산자를 입력하세요.");
        }
        results.add(result); // 연산 결과를 ArrayList에 저장
        return result;
    }

    // getter 메서드 추가
    public ArrayList<Integer> getResults() {
        return new ArrayList<>(results); // 저장된 연산 결과를 반환하기
    }
    //inquiry 메서드 추가
    public void inquiryResults() {
        System.out.println("저장된 연산 결과를 조회합니다.");
        for (int res : results) {
            System.out.println(res);
        }
    }
    // removeResult 추가
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 가장 먼저 저장된 데이터 삭제
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}
