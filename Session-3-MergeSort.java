import java.util.*;

class Main {
    public static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSortHelper(int[] arr, int low, int high) {
        if (low>=high) {
            return;
            // if the array has just 0 or 1 elements then there is nothing to sort
        }
        int mid = (low+high)/2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid+1, high);

        int[] arr1 = new int[mid-low+1];
        int[] arr2 = new int[high-mid];
        for (int i=0; i<arr1.length; i++) {
            arr1[i] = arr[low+i];
        }
        for (int i=0; i<arr2.length; i++) {
            arr2[i] = arr[mid+1+i];
        }

        int p1 = 0; int p2 = 0; int index = low;
        while (p1<arr1.length && p2<arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                arr[index] = arr1[p1];
                ++index;
                ++p1;
            } else {
                arr[index] = arr2[p2];
                ++index;
                ++p2;
            }
        }
        while (p1<arr1.length) {
            arr[index] = arr1[p1];
            ++index;
            ++p1;
        }
        while (p2<arr2.length) {
            arr[index] = arr2[p2];
            ++index;
            ++p2;
        }
    }
    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,10,9,4,3};
        mergeSort(arr);
        Arrays.sort(arr); // this is the inbuilt function os java for sorting arrays
        printArray(arr);
    }    
}
