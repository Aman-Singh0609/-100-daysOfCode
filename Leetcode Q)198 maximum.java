package house;
import java.util.*;
public class maximum {
	static int rob(int nums[])
	{
		/*
		 * int n = nums.length; int n1 = (n + 1) / 2; int n2 = n / 2;
		 * 
		 * int[] num1 = new int[n1]; int[] num2 = new int[n2];
		 * 
		 * int oddIndex = 0; int evenIndex = 0;
		 * 
		 * for (int i = 0; i < n; i++) { if (i % 2 == 0) { num1[evenIndex++] = nums[i];
		 * } else { num2[oddIndex++] = nums[i]; } } return maxArea(num1,num2); } static
		 * int maxArea(int num1[], int num2[]) { int sum=0; int sum1=0; for(int
		 * i=0;i<num1.length;i++) { sum += num1[i]; } for(int j=0;j<num2.length;j++) {
		 * sum1 += num2[j]; }
		 *///return Math.max(sum, sum1); 
		int n = nums.length;
		if(nums == null || n ==0)
		{
			return 0;
		}
		if(n == 1)
		{
			return nums[0];
		}
		int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[n - 1];
	}
	public static void main(String args[])
	{
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}
}
