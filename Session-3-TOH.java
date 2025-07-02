import java.util.*;

class Main {
    public static int c = 0;
    public static void towerOfHanoi(int n, char A, char B, char C) {
      if (n==0) {
        // then I don't have to do anything since there are 0 disks
        return;
      }
      if (n==1) {
        ++c;
        System.out.println(n+": "+ A+" "+C);
        return;
      }
      ++c;
      towerOfHanoi(n-1, A, C, B); // I have to move the n-1 disks from A to B
      // so A becomes my source rod and B becomes my desitnation rod
      System.out.println(n+": "+ A+" "+C);
      // I will move the nth disk from A to C
      towerOfHanoi(n-1, B, A, C);
    }
    public static void main(String[] args) {
      towerOfHanoi(6, 'A', 'B', 'C');
      System.out.println("The total number of steps = "+c);
  }
}