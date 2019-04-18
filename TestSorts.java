/***********
Roman Alonzo
CS 241
Lab2
***********/
import java.util.*; 

public class TestSorts{

 //return true if the array is sorted in ascending order and return false otherwise
 public static boolean isSorted(int[] A){
   //go through array
   for (int i=0; i<A.length - 1; i++){
      //if the previous value is more than the next one it's not sorted
      if (A[i] > A[i+1]){
         return false;  
      }
   }
   return true;
}

 //return true if both arrays have same counts of elements, and return false otherwise
 public static boolean sameElements(int[] A, int[] B){
   for (int i = 0; i < A.length; i++) {
     int curr = A[i];
     
     int A_count = 0;
     //go through array A and count up the elements
     for (int j = 0; j < A.length; j++) {
       if (A[j] == curr) {
          A_count++;
       }
     }
     //go through array B and count up the elements
     int B_count = 0;
     for (int j = 0; j < B.length; j++) {
       if (B[j] == curr) {
          B_count++;
       }
     }
     //compare the counts of both arrays
     if (A_count != B_count) {
       return false;
     }
   }
   return true;
}   
 
 //reads space seperated line of ints and returns the values in an int array  
 public static int[] arrayFromConsole(){
   Scanner input = new Scanner(System.in);
   int length = input.nextInt();
   input.nextLine(); 
   
   //initialize empty array of the length of the input
   int [] array = new int[length];
   Scanner arrScan = new Scanner(input.nextLine());
   
   //go through length of input to put into array
   for (int i = 0; i < length; i++) {
       //if console isn't empty basically
       if (arrScan.hasNextInt()) {
           array[i] = arrScan.nextInt();
       //otherwise, tell user to input values    
       } else {
           System.out.println("Input values from console");
           break;
       }
   }
   
   //return populated array
   return array;
}
 
 //read a line of ints using arrayFromConsole    
 private static void testFromConsole(){
   int[] array = arrayFromConsole();
   Sorts s = new Sorts();
   
   //sort the int array using insertionSort
   s.insertionSort(array, 0, array.length);
   
   //feed output into isSorted and sameElements
   boolean sorted = isSorted(array);
   boolean same = sameElements(array, array);
   
   //compare booleans
   if (sorted == same){
      System.out.println("Passed Test");
   } else{
      System.out.println("FAILED Test");
   }
 }
    
 private static void shuffleTest(int N){
   //generates integer array of length N
   int[] array = new int[N];
   Sorts s = new Sorts();
   Random random = new Random();
   random.nextInt();
   //randomly shuffle array
   for (int i = 0; i < array.length; i++){
      int newPos = i + random.nextInt(array.length-i);
      swap(array, i, newPos);
   }
   //use insertion sort on shuffled array
   s.insertionSort(array, 0, array.length);   
   //feed output into isSorted to check if it worked   
   if (isSorted(array)){
      System.out.println("Passed Test");
      
   } else{
      System.out.println("Failed Test");
   } 
 }
 
 //swap method from Sorts.java
 public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
 }
 
 public static void main(String[] args){
   //if there's no command line args, run testFromConsole
   if (args.length == 0){
      testFromConsole();
   //otherwise, parse as int values and run shuffleTest   
   }else{
      for (int i = 0; i < args.length; i++){
         shuffleTest(i);  
      }
   }
 }
}
