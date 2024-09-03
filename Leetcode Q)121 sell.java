package profit_stock;

public class sell {
    public static int function(int[] prices) {
//        int small = prices[0];
//        int smallestIndex = 0; // To track the index of the smallest number
//        int largest = 0;
//        int left = 0;
//        int right = 1;
//
//        while (right < prices.length) {
//            if (prices[left] < prices[right]) {
//                small = prices[left];
//            } else {
//                small = prices[right];
//            }
//
//            if (small < prices[smallestIndex]) {
//                smallestIndex = (prices[left] < prices[right]) ? left : right; // Update smallestIndex
//            }
//
//            left++;
//            right++;
//        }
//
//        // Check if we have at least one larger element after the smallest element
//        if (smallestIndex < prices.length - 1) {
//            left = smallestIndex + 1; // Move left to the smallest index + 1
//            right = left + 1; // Start right one step ahead of left
//
//            largest = prices[left]; // Initialize largest with the first element after the smallest
//
//            while (right < prices.length) {
//                if (prices[left] < prices[right]) {
//                    largest = Math.max(largest, prices[right]);
//                } else {
//                    largest = Math.max(largest, prices[left]);
//                }
//                left++;
//                right++;
//            }
//        } else {
//            return 0; // If smallest is at the last position, no profit can be made
//        }
//
//        // Calculate and return the maximum profit
//        int maxProfit = largest - prices[smallestIndex];
//        return maxProfit;
    	int small=prices[0];
    	int maxprofit = 0;
    	if(prices == null || prices.length == 0 || prices.length == 1)
    	{
    		return 0;
    	}
    	for(int i = 1;i<prices.length;i++)
    	{
    		maxprofit = Math.max(maxprofit,prices[i] - small);
    		small = Math.min(small, prices[i]);
    	}
    	return maxprofit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int result = function(arr);
        System.out.println("Maximum Profit: " + result); 
    }
}
