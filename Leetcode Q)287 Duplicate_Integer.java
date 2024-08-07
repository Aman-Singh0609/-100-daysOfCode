package duplicate_integer;
import java.util.*;
public class integer {
	public static int findDuplicate(int[] nums) {
		Set<Integer> s1 = new HashSet<Integer>();
		int[] oneArray = new int[1];
		int n = nums.length;
		for(int i=0;i<n;i++)
		{
			int x = nums[i];
			if(!s1.contains(x))
			{
				s1.add(x);
			}
			else
			{
				oneArray[0] = x;
				//System.out.println(y);
				break;
			}
		}
		return oneArray[0];
    }
	public static void main(String args[])
	{
		int[] nums = {1,3,4,2,2};
		int[] nums1 = {3,1,3,4,2};
		//int[] nums2 = {1,3,3,2,2};
		System.out.println(findDuplicate(nums));
		System.out.println(findDuplicate(nums1));
		
	}
}
