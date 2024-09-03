package leetcode_16;
import java.util.*;
public class array {
	public static int[] twoSum(int[] numbers, int target) {
		int n = numbers.length;
		int[] index = new int[2];
		int left =0;
		int right = n-1;
		while(left<right)
		{
			if(numbers[left] + numbers[right] == target)
			{
				index[0] = left+1;
				index[1] = right+1;
				left++;
				right--;
			}
			if(numbers[left] + numbers[right] > target)
			{
				right--;
			}
			else
			{
				left++;
			}
		}
        return index;
    }
	public static void main(String args)
	{
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] ok  = twoSum(numbers,target);
		for(int i =0;i<ok.length;i++)
		{
			System.out.println(ok[i]);
		}
	}
}
