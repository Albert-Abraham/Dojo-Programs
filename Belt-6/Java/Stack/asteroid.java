/*  You are given an array of integers representing asteroids in a row. For each asteroid: The absolute value represents its size. The sign represents its direction: Positive + means moving to the right. Negative - means moving to the left. Asteroids moving at the same speed will collide if they meet, resulting in one or both being destroyed based on their size. Your task is to determine the final state of the asteroids after all collisions.
*/
package Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class asteroid {

    public static void main(String[] args) {

        Scanner ob = new Scanner(System.in);
        int n = ob.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ob.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : arr) {

            if (i > 0) {
                stack.push(i);
            } else {

                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                } 
                else if (stack.peek() == -i) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Everything Destroyed");
        } else {
            while (!stack.isEmpty()) {
                System.out.print(stack.peekLast() + " ");
                stack.removeLast();
            }
        }

        ob.close();
    }
}