package demoGL.Denomination;

import java.util.Scanner;

public class Currency {
	public static void merge(int arr[], int first, int mid, int last) {
		// Find sizes of two sub arrays to be merged
				int n1 = mid - first + 1;
				int n2 = last - mid;

				/* Create temporary arrays */
				int firstArray[] = new int[n1];
				int lastArray[] = new int[n2];

				/* Copy data to temporary arrays */
				for (int i = 0; i < n1; ++i)
					firstArray[i] = arr[first + i];
				for (int j = 0; j < n2; ++j)
					lastArray[j] = arr[mid + 1 + j];

				/* Merge the temporary arrays */

				// Initial indexes of first and second sub-arrays
				int i = 0, j = 0;

				// Initial index of merged sub-array array
				int k = first;
				while (i < n1 && j < n2) {
					if (firstArray[i] >= lastArray[j]) {
						arr[k] = firstArray[i];
						i++;
					} else {
						arr[k] = lastArray[j];
						j++;
					}
					k++;
				}

				/* Copy remaining elements of L[] if any */
				while (i < n1) {
					arr[k] = firstArray[i];
					i++;
					k++;
				}

				/* Copy remaining elements of R[] if any */
				while (j < n2) {
					arr[k] = lastArray[j];
					j++;
					k++;
				}
			}

	public static void mergeSort(int notes[], int first , int last ) {
		//divide
		//[5 , 1 , 10, 6, 4]
		int mid;
		if(first<last) {
			//find the middle point
			mid = (first+last)/2;
			
			//Sort first and second halves
			mergeSort(notes, first, mid);	
			mergeSort(notes, mid+1, last);
			
			//Merge the sorted halves
			merge(notes,first , mid, last);

		}
		
	}

	public static void main(String[] args) {
		System.out.println("Enter number of denomination ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int denominations[] = new int[n];
		for(int i=0; i<n ; i++) {
			System.out.println("Enter denominations ");
			denominations[i] = sc.nextInt();
		}
		mergeSort(denominations, 0, denominations.length-1);
		for(int i=0 ; i<denominations.length; i++)
			System.out.println(denominations[i]);
		System.out.println("Enter the amount you want to pay: ");
		int amt = sc.nextInt();
		
		for(int i=0 ; i<denominations.length; i++) {
			if(amt>denominations[i]) {
				int notes = amt / denominations[i];
				System.out.println(denominations[i]+ " :" + notes);
				amt =amt % denominations[i];
				
			}
			
		}
		if(amt > 0)
		    System.out.println("remaining amount: "+amt);
		
	}
}
