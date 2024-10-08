
import java.util.Stack;

public class ValidParanthesis {

    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char top = stack.isEmpty() ? ' ' : stack.peek();

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' && top == '(' && !stack.isEmpty()) {
                stack.pop();
            } else if (current == ']' && top == '[' && !stack.isEmpty()) {
                stack.pop();
            } else if (current == '}' && top == '{' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(' ) {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[' ) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
