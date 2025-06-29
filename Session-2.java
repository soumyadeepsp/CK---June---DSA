import java.util.*;

class Main {
    // question - calculate x^n
    public static int power(int x, int n) {
      if (n==0) {
        return 1;
      }
      if (n==1) {
        return x;
      }
      int smallerAnswer = x;
      int biggerAnswer = power(x, n-1);
      int finalAnswer = smallerAnswer * biggerAnswer;
      return finalAnswer;
    }
    
    // given a number, find the number of digits in 
    public static int numberOfDigits(long n) {
      if (n<10) {
        // this means that n is just a single digit number
        return 1;
      }
      int smallerAnswer = 1;
      int biggerAnswer = numberOfDigits(n/10);
      int finalAnswer = smallerAnswer + biggerAnswer;
      return finalAnswer;
      // return numberOfDigits(n/10)+1;
    }
    
    public static void printNumbers(int n) {
      if (n==5) {
        return;
      }
      printNumbers(n+1);
      System.out.println(n);
    }
    
    // find the sum of all the elements in an array
    public static int sumOfArray(int[] arr) {
      if (arr.length==0) {
        return 0;
      }
      if (arr.length==1) {
        return arr[0];
      }
      int smallerAnswer = arr[0];
      int[] newArray = new int[arr.length-1];
      for (int i=0; i<newArray.length; i++) {
        newArray[i] = arr[i+1];
      }
      int biggerAnswer = sumOfArray(newArray);
      int finalAnswer = smallerAnswer + biggerAnswer;
      return finalAnswer;
    }
    
    public static int sumOfArrayHelper(int[] arr, int low, int high) {
      if (low>high) {
        return 0;
      }
      if (low==high) {
        return arr[low];
      }
      int smallerAnswer = arr[low];
      int biggerAnswer = sumOfArrayHelper(arr, low+1, high);
      int finalAnswer = smallerAnswer + biggerAnswer;
      return finalAnswer;
      // return sumOfArrayHelper(arr, low+1, high)+arr[low];
    }
    
    public static int sumOfArraySmarter(int[] arr) {
      // in the very first function call, the entire array is under consideration and thus 
      // low is pointing to the very first index that is 0
      // and high is pointing to the very last index that is length-1
      return sumOfArrayHelper(arr, 0, arr.length-1);
    }
    
    public static int findFirstIndexHelper(int[] arr, int low, int high, int x) {
      if(low>high) {
        // this means that the arrays has 0 elements
        return -1;
      }
      if (low==high) {
        // this means the arrays has just 1 element
        if (arr[low]==x) {
          return low;
        } else {
          return -1;
        }
      }
      int smallerAnswer = -1;
      if (arr[low]==x) {
        smallerAnswer = low;
      }
      int biggerAnswer = findFirstIndexHelper(arr, low+1, high, x);
      if (smallerAnswer!=-1 && biggerAnswer!=-1) {
        // I have found x in both smallerAnswer and biggerAnswer
        int finalAnswer = smallerAnswer;
        return finalAnswer;
      } else if (smallerAnswer!=-1 && biggerAnswer==-1) {
        // I have found x only in smallerAnswer but not in biggerAnswer
        int finalAnswer = smallerAnswer;
        return finalAnswer;
      } else if (smallerAnswer==-1 && biggerAnswer!=-1) {
        // I have found x only in biggerAnswer but not in smallerAnswer
        int finalAnswer = biggerAnswer;
        return finalAnswer;
      } else {
        // I have not found x in smallerAnswer or in biggerAnswer
        int finalAnswer = -1;
        return finalAnswer;
      }
    }
    
    // Find the first index of a number in an array and if it is not present then return -1
    public static int findFirstIndex(int[] arr, int x) {
      return findFirstIndexHelper(arr, 0, arr.length-1, x);
    }
    
    public static void main(String[] args) {
      long n = 1234763283l;
      // System.out.println(numberOfDigits(n));
      // printNumbers(1);
      int[] arr = {1,2,3,4,5,6};
      System.out.println(findFirstIndex(arr, 4));
  }
}