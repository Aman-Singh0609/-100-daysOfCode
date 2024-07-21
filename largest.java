package histogram;
import java.util.*;

public class largest {
    public static int largestRectangleArea(int[] heights) {
        List<Integer> l1 = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            l1.add(heights[i]);
        }

        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : l1.get(i);

            while (!s1.isEmpty() && l1.get(s1.peek()) > currentHeight) {
                int height = l1.get(s1.pop());
                //System.out.println(height);
                int width = s1.isEmpty() ? i : i - s1.peek() - 1;
                //System.out.println(width);
                maxArea = Math.max(maxArea, height * width);
                System.out.println(maxArea);
            }

            s1.push(i);
        }

        printStack(s1, l1);
        return maxArea;
    }

    static void printStack(Stack<Integer> s1, List<Integer> l1) {
        System.out.println("Remaining indices in stack (these are not processed as they form heights <= current height at i):");
        while (!s1.isEmpty()) {
            int index = s1.pop();
            System.out.println("Index: " + index + " Height: " + (index < l1.size() ? l1.get(index) : "N/A"));
        }
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + maxArea);
    }
}
