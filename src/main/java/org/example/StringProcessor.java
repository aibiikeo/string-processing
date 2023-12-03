package org.example;

import java.util.Stack;

public class StringProcessor {
    public boolean isStrongPassword(String password) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!*_+-]).{8,}")) return true;
        return false;
    }

    public int calculateDigits(String sentence) {
        int x = 0;
        for (char i : sentence.toCharArray()) {
            if (i > 47 && i < 58)
                x++;
        }
        return x;
    }

    public int calculateWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    public Double calculateExpression(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }

            else if (Character.isDigit(tokens[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i++]);
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            }

            else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            }

            else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Discard '('
            }

            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')') && ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }

    private static double applyOperator(char operator, double b, double a) {
        if (operator == '+')
            return a + b;
        else if (operator == '-')
            return a - b;
        else if (operator == '*')
            return a * b;
        else if (operator == '/'){
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
        return 0;
    }
}
