/********************
Roman Alonzo
CS 241
A1 driver for Sorts.java
*********************/

import java.util.*;
import java.util.Random;

public class SortsDriver {
    public static void main(String[] args) {
        //Track user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter sort (i[nsertion], q[uick], m[erge], r[adix], a[ll]): ");
        //First input is the sorting method the user wants to use
        String sort = input.next();

        System.out.println("Enter n (size of array to sort): ");
        //Second input is the size they want the array to be
        int size = input.nextInt();
        Random rand = new Random();
        int[] A = new int[size];
        //randomly generate an array with the max being the array size
        for (int i = 0; i < A.length; i++) {
            int randomInt = rand.nextInt(size);
            A[i] = randomInt;
        }
        Sorts s = new Sorts();
        
        //insertion
        if (sort.equals("i")) {
            s.insertionSort(A, 0, A.length);
            System.out.println("Insertion: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
        }
        
        //quick
        else if (sort.equals("q")) {

            s.quickSort(A, 0, A.length - 1);
            System.out.println("Quick: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
        }
        
        //radix
        else if (sort.equals("r")) {
            System.out.println("Radix:");
            s.radixSort(A, size);
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
        }
        
        //merge
        else if (sort.equals("m")) {
            s.mergeSort(A, 0, A.length - 1);
            System.out.println("Merge: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
         }
         
         //all
         else if (sort.equals("a")) {
            s.quickSort(A, 0, A.length - 1);
            System.out.println("Quick: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }  
            
            s.radixSort(A, size);
            System.out.println("Radix:");
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }

            s.mergeSort(A, 0, A.length - 1);
            System.out.println("Merge: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
            
            s.insertionSort(A, 0, A.length); 
            System.out.println("Insertion: " + s.getComparisonCount());
            s.resetComparisonCount();
            if (size <= 20) {
                System.out.print("[ ");
                for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i] + " ");
                }
                System.out.println("]");
            }
            
        }
    }    
}  
