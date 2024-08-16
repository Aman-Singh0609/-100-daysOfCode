package binary_search;
import java.util.*;
public class search {
	public static int search(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n-1;
		int middle =0;
		while(left<=right)
		{
			middle = (left + (right-left)/2);
			if(target == nums[middle])
			{
				return middle;
			}
			if(nums[middle] > target)
			{
				right = middle-1;
			}
			else
			{
				left = middle+1;
			}
		}
        return -1;
    }
	public static void main(String args[])
	{
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		System.out.println(search(nums,target));
	}
}
