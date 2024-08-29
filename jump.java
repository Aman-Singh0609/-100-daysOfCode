package jump_game;
import java.util.*;
public class jump {
	public static boolean canJump(int[] nums) {
//		int jumpPoint = 0;
//		int jumpValue = nums[0];
//		int n = nums.length;
//		if(n == 1)
//		{
//			return true;
//		}
//		while(jumpPoint < n-1)
//		{
//			jumpValue = nums[jumpPoint];
//			if(jumpValue == 0)
//			{
//				break;
//			}
//			jumpPoint  = jumpPoint + jumpValue;
//			if(jumpPoint >= n-1)
//			{
//				return true;
//			}
//		}
//        return false;
		int jumpPoint = 0;
        int n = nums.length;


        if (n == 1) {
            return true;
        }

        while (jumpPoint < n - 1) {
            int jumpValue = nums[jumpPoint];

            
            if (jumpValue == 0) {
                
                boolean canPassZero = false;
                for (int i = jumpPoint - 1; i >= 0; i--) {
                    if (i + nums[i] > jumpPoint) {
                        jumpPoint = i + nums[i];
                        canPassZero = true;
                        break;
                    }
                }

                
                if (!canPassZero) {
                    return false;
                }
            } else {
                
                jumpPoint += jumpValue;
            }

            
            if (jumpPoint >= n - 1) {
                return true;
            }
        }

        
        return false;
    }
	public static void main(String args[])
	{
		int[] nums = {2,1,0,1};
		System.out.println(canJump(nums));
	}
	
}
