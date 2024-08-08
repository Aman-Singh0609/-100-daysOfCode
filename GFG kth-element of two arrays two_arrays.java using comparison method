package kth_element;
import java.util.*;
public class two_arrays {
	public static int[] compare(int arr1[],int arr2[],int n,int m)
	{
		int[] arr4 = new int[n+m];
		int i=0,j=0,k=0;
		while(i<n && j<m)
		{
			if(arr1[i] >= arr2[j])
			{
				arr4[k++] = arr2[j++];
			}
			else
			{
				arr4[k++] = arr1[i++];
			}
		}
		while(i<n)
		{
			arr4[k++] = arr1[i++];
		}
		while(j<m)
		{
			arr4[k++] = arr2[j++];
		}
		return arr4;
		
	}
	public long kthElement(int k, int arr1[], int arr2[]) {
		int n = arr1.length;
		int m = arr2.length;
		int[] arr4 = compare(arr1,arr2,n,m);
		return arr4[k-1];
    }
	public static void main(String args[])
	{
		int k = 2;
		int[] arr1 = {5,5,8,8,8,9,11,11,11,11,11};
		int[] arr2 = {4,4,4,4,6,8,9,9,9,11,13};
		two_arrays t1 = new two_arrays();
		System.out.println(t1.kthElement(k, arr1, arr2));
	}
}
