
public class MergeSort {
	
	private void merge(int arr[], int L, int M, int R) {
	    int LEFT_SIZE = M - L;
	    int RIGHT_SIZE = R - M + 1;
	    int[] left = new int[LEFT_SIZE];
	    int[] right = new int[RIGHT_SIZE];
	    int i, j, k;
	    
	    // 1. Fill in the left sub array
	    for (i=L; i<M; i++) {
	        left[i-L] = arr[i];
	    }
	    // 2. Fill in the right sub array
	    for (i=M; i<=R; i++) {
	        right[i-M] = arr[i];
	    }
	    
	    // 3. Merge into the original array
	    i = 0;  j = 0;  k = L;
	    while (i < LEFT_SIZE && j < RIGHT_SIZE) {
	        if (left[i] < right[j]) {
	            arr[k] = left[i];
	            i++;
	            k++;
	        }
	        else {
	            arr[k] = right[j];
	            j++;
	            k++;
	        }
	    }
	    
	    while (i < LEFT_SIZE) {
	        arr[k] = left[i];
	        i++;
	        k++;
	    }
	    while (j < RIGHT_SIZE) {
	        arr[k] = right[j];
	        j++;
	        k++;
	    }
	}

	private void mergeSort(int arr[], int L, int R) {
	    if (L == R) {
	        return;
	    }
	    else {
	        int M = (L + R) / 2;
	        mergeSort(arr, L, M);
	        mergeSort(arr, M+1, R);
	        merge(arr, L, M+1, R);
	    }
	}
	
	public void mergeSort(int arr[]) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort sorter = new MergeSort();
		int[] arr = {5, 2, 3, 4, 8, 1, 12, 19, 10, 7, 6};
		sorter.mergeSort(arr);
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
