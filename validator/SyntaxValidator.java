package validator;

import implementation.ArrayStack;

public class SyntaxValidator {

    public boolean isBalanced(String expression) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        for(char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                try {
                    char top = stack.pop();
                    if (!isMatch(ch, top)) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char ch, char top) {
        return (ch == ')' && top == '(') ||
            (ch == '}' && top == '{') ||
            (ch == ']' && top == '[');
    }
}
