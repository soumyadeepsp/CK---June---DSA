import java.util.*;

class Main {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot will always be the last element in the array under consideration
        int i=low-1; // low is the first index of the array under consideration and pointer i is starting before it
        for (int j=low; j<high; j++) { // j is going from low till just before pivot
            if (arr[j]<pivot) { // this is the criteria using which I am filterin the elements
                // which ever element fulfills this criteria will be pushed towards the left of the array
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    public static void quickSortHelper(int[] arr, int low, int high) {
        if (low>=high) {
            // it means the array has either 0 or 1 element
            // in both the cases we don't need to sort anything and can simply return
            return;
        }
        int pi = partition(arr, low, high);
        // the job of this parition function is to move the pivot element to its correct position in the sorted array
        // after this, it needs to move all the elements smaller than pivot to its left and larger than pivot to its right
        // and also return the index of the correct position of the pivot element
        quickSortHelper(arr, low, pi-1);
        quickSortHelper(arr, pi+1, high);
    }
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,9,7,5,6};
        quickSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}