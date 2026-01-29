import java.util.*;
public class containerWithMostWater {

    public static void main(String[] args) {
        //input an array and pass it though the maxArea function
        System.out.println("hello");
    }
    
    public int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(arr[left], arr[right]);
            int w = right - left;
            int currArea = h * w;
            maxArea = Math.max(currArea, maxArea);
            if (arr[left] < arr[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}