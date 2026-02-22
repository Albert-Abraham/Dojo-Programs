package Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class smallestInteger {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        String num = ob.next();
        int k = ob.nextInt();

        Deque<Character> stack = new ArrayDeque<>();

        // Greedy removal using monotonic increasing stack
        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        // If k still remains, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result in correct order
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        // Remove leading zeros
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        String finalResult = result.substring(i);

        // If empty, return "0"
        if (finalResult.length() == 0) {
            finalResult = "0";
        }

        System.out.println(finalResult);
    }
}
