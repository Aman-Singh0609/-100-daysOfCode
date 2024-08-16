package search_2d_matrix;
import java.util.*;
public class matrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = row*col-1 ;
		
		while(left<=right)
		{
			int middle = left + (right-left/2);
			int middleElement = matrix[middle/col][middle%col];
			if(middleElement == target)
			{
				return true;
			}
			if(middleElement < target)
			{
				left = middle +1;
			}
			else
			{
				right = middle -1;
			}
		}
        return false; 
    }
	public static void main(String args[])
	{
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 100;
		int n = matrix.length;
		//System.out.println(n);
//		for(int i=0;i<matrix.length;i++)
//		{
//			for(int j=0;j<matrix[i].length;j++)
//			{
//				System.out.println(matrix[i][j] + "");
//			}
//			System.out.println();
//		}
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
//		int row = matrix.length;
//		int col = matrix[0].length;
//		int left = 0;
//		int right = row*col-1 ;
//		
//		while(left<=right)
//		{
//			int middle = left + (right-left/2);
//			System.out.println(middle);
//			int middleElement = matrix[middle/col][middle%col];
//			System.out.println(middleElement);
//		}
		boolean found;
		found = searchMatrix(matrix,target);
		System.out.println(found);
		
	}
}
