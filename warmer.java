package leetcode_739;
import java.util.*;
public class warmer {
	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		Stack<Integer> s1 = new Stack<Integer>();
		int[] newtemp = new int[n];
//		for(int i=n-1;i>=0;i--)
//		{
//			s1.push(temperatures[i]);
//		}
//		int i=0;
//		int k=0;
//		int count=0;
//		while (!s1.isEmpty()) {
//            while (i < n - 1 && temperatures[i + 1] <= s1.peek()) {
//                i++;
//                count++;
//            }
//            
//            if (i < n - 1) {
//                newtemp[k++] = count + 1; 
//            } else {
//                newtemp[k++] = 0;  
//            }
//            
//            count = 0;  
//            s1.pop();  
//            
//            i = k;  
//        }
		for(int i=0;i<n;i++)
		{
			while(!s1.isEmpty() && temperatures[i] > temperatures[s1.peek()])
			{
				int ithday = s1.pop();
				newtemp[ithday] = i - ithday;
			}
			s1.push(i);
		}
        return newtemp; 

    }
	public static void main(String args[])
	{
		int[] temperatures = {30,40,50,60};
		int[] nums = dailyTemperatures(temperatures);
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
	}
}
