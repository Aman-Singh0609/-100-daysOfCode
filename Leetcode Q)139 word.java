package wordBreak;

import java.util.*;

public class word {
    public static void main(String[] args) {
		/*
		 * // Example 1 String s1 = "leetcode"; List<String> wordDict1 =
		 * Arrays.asList("leet", "code"); System.out.println(wordBreak(s1, wordDict1));
		 * // Output: true
		 */
        // Example 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s2, wordDict2)); // Output: true
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        //yeh aasume krke ke chal le rhe ki empty string toh hamesha segmented hogi
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // check kr rhe hai kya jo substring s string se milegi voh hamari HashSet me hai ya nhi
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]== true && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
