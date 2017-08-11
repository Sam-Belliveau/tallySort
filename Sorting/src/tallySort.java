import java.util.Random;
public class tallySort {
	public static void main(String[] args){
		// Makes random list
		Random rand = new Random();
		long startTime = System.nanoTime();
		int indexList[] = new int[100000000];
		int quickList[] = new int[100000000];
		int temp;
		for(int i = 0; i < indexList.length; i++){
			temp = rand.nextInt(indexList.length);
			indexList[i] = temp;
			quickList[i] = temp;
		}
		long endTime = System.nanoTime();
		long listTime = ((endTime - startTime)/1000000);
		System.out.println("A Random List With " + indexList.length + " Items In It Was Made In " + listTime + "ms.\n\nStarting Sort:");
		
		// Find Time For Index Sort (BY SAM BELLIVEAU)
		startTime = System.nanoTime();
		indexSort(indexList, indexList.length);
		endTime = System.nanoTime();
		
		long indexTime = ((endTime - startTime)/1000000);
		System.out.println("Index Sort has sorted " + indexList.length + " items in " + indexTime + "ms.");
		
		// Find Time For Quick Sort
		startTime = System.nanoTime();
		quickSort(quickList, 0, quickList.length-1);
		endTime = System.nanoTime();
		
		long quickTime = ((endTime - startTime)/1000000);
		System.out.println("Quick Sort has sorted " + quickList.length + " items in " + quickTime + "ms.\n");
		
		// Print Winner
		if (indexTime>quickTime){
			System.out.println("Quick Sort Was " + (indexTime-quickTime) + "ms Faster Than Index Sort");
		}else{ System.out.println("Index Sort Was " + (quickTime-indexTime) + "ms Faster Than Quick Sort"); }
		
		/*
		for(int i = 0; i < indexList.length; i++){
			System.out.print(indexList[i] + ",  ");
		}
		*/
		
		
	}
	
	public static void indexSort(int[] list, int m){// MY SORT
		int max;
		if (m == 0){
			max = 0;
			for (int i = 0; i < list.length; i++){
				if(list[i] > max){ max = list[i]; }
			}
			
		}else{ max = m; }
		int tally[] = new int[max+1];
		for (int i = 0; i < list.length; i++){
			tally[list[i]] += 1;
		}
		int j = 0;
		for (int i = 0; i < tally.length; i++){
			for(int l = 0; l < tally[i]; l++){
				list[j] = i;
				j++;
			}
		}
		return;
	}
	
	public static void quickSort(int[] arr, int low, int high) { // MOST POPULAR SORT
		if (arr == null || arr.length == 0)
			return;
		if (low >= high)
			return;
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}
}
