package longest_repeating_character;
import java.util.*;
public class replacement {
	public static int characterReplacement(String s, int k) {
		int length=0;
		int[] arr = new int[26];
		int Max=0;
		int left = 0;
		for(int right=0;right<s.length();right++)
		{
			arr[s.charAt(right) -'A']++;
			length = Math.max(length, arr[s.charAt(right) - 'A']);
			
			while(right - left + 1 - length> k) // matlab current window ki size me k se zyaada elements ko update krna padega jo ki galat hai
			{
				arr[s.charAt(left) - 'A']--;
				left++;
			}
			Max = Math.max(Max, right - left + 1);
		}
		return Max;
    }
	public static void main(String args[])
	{
		String s = "BAABAA";
		int k = 1;
		System.out.println(characterReplacement(s,k));
	}
}
