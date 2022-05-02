package step2;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator extends ArithmeticCalculator {

    private final static String[] operators = {"+", "-", "*", "/"};

    public int calculation(final String str) {
        String[] input = isStringNullCheck(str);
        Optional<String> optOperator = Optional.empty();
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (isOperator(input[i])) {
                optOperator = Optional.of(input[i]);
            } else {
                int y = Integer.parseInt(input[i]);
                result = selectArithmeticOperation(optOperator.get(), result, y);
            }
        }

        return result;
    }

    private String[] isStringNullCheck(final String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return str.split(" ");
    }

    private final boolean isOperator(final String str) {
        if (Arrays.asList(operators).contains(str)) {
            return true;
        }
        return false;
    }

    private int selectArithmeticOperation(final String operator, final int x, final int y) {
        switch (operator) {
            case "+":
                return super.add(x, y);
            case "*":
                return super.multiplication(x, y);
            case "-":
                return super.minus(x, y);
            case "/":
                return super.division(x, y);
        }
        return 0;
    }
}