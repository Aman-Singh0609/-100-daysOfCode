package top_k_frequent;
import java.util.*;
import java.util.Map.Entry;
public class frequent {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> m1  = new HashMap<Integer,Integer>();
		//List<Integer> l1 = new ArrayList<>();
		Queue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
		if(nums.length == 1)
		{
			return nums;
		}
		for(int i=0;i<nums.length;i++)
		{
			if(m1.containsKey(nums[i]))
			{
				m1.put(nums[i], m1.get(nums[i])+1);
			}
			else
			{
				m1.put(nums[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
		maxHeap.addAll(m1.entrySet());
		int[] n1 = new int[k];
		for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();  // Remove and return the top element
            n1[i] = entry.getKey();  // Store the key in the array
        }
		/*
		 * boolean allValuesAreOne = true; for (Integer count : m1.values()) { if (count
		 * != 1) { allValuesAreOne = false; break; } }
		 */
		/*
		 * if (allValuesAreOne) { return nums; }
		 */
//		for(Map.Entry<Integer, Integer> e1 : m1.entrySet())
//		{
//			if (e1.getValue() > 1) {
//                l1.add(e1.getKey());
//            }
//		}
//		int[] n1 = new int[k];
//		int start=0;
//		for(int j=0;j<l1.size();j++)
//		{
//			n1[start++] = l1.get(j);
//		}
        return n1;
    }
	public static void main(String args[])
	{
		int nums[] = {1,1,1,2,2,3};
		int k = 2;
		int[] n2 = topKFrequent(nums,k); 
		for(int i=0;i<k;i++)
		{
			System.out.println(n2[i]);
		}
	}
}
