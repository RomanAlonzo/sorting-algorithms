/***********
 Roman Alonzo
 CS 241
 Assignment 1
 ***********/

/*******************************************
 References:
 VisuAlgo.net sorting algorithm visualizer
 Lecture slides
 Intro to Algorithms 3rd Edition (2.1, 7, 8.2-4)
 *******************************************/

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Sorts {

    private int comparisonCount; // maintains a count comparisons performed by this Sorts object

    public int getComparisonCount() {
        return comparisonCount;
    }

    public void resetComparisonCount() {
        comparisonCount = 0;
    }

/**************************************************************************************/
    /**
     * use insertion sort to sort A[start..end] in place
     * precondition: 0 <= start <= end <= A.length
     */
    public void insertionSort(int[] A, int start, int end) {
        //iterate through A from the start
        for (int i = 1; i < end; i++) {
            int key = A[i];
            start = i - 1;
            //move sorted element to the right by 1
            while (start >= 0 && A[start] > key) {
                A[start + 1] = A[start];
                start = start - 1;
                comparisonCount++;
            }
            A[start + 1] = key;
        }
    }

/***************************************************************************************/
    /**
     * partition A around the pivot A[pivIndex]. return the pivot's new index.
     * precondition: start <= pivIndex < end
     * postcondition: A[start..i] <= A[i] <= A[i+1..end]
     * where i is the return value
     */
    public int partition(int[] A, int start, int end, int pivIndex) {

        //int pivot = A[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (A[j] <= pivIndex) {
                i++;
                swap(A, i, j);
                comparisonCount++;
            }
        }
        swap(A, i + 1, end);
        return i + 1;
    }

    /**
     * use quicksort to sort the subarray A[start..end]
     */
    public void quickSort(int[] A, int start, int end) {
        //if the start is larger than the end, quit out
        if (start >= end)
            return;

        //make a position the pivot. Maybe switch to median later.
        int pivot = A[end];
        int divide = partition(A, start, end, pivot);

        //call quickSort with the pivot dividing each side for partitioning
        quickSort(A, start, divide - 1);
        quickSort(A, divide + 1, end);
    }

/**************************************************************************************/
    /**
     * merge the sorted subarrays A[start..mid] and A[mid..end] into
     * a single sorted array in A.
     */
    //pages 12, 30–37, 797–805
    public void merge(int[] A, int start, int mid, int end) {
        //make temporary array to copy elements into
        int[] tempArray = new int[A.length];

        for (int i = start; i <= end; i++) {
            tempArray[i] = A[i];
        }

        //make temporary start and end values
        int tempStart = start;
        int tempEnd = mid + 1;
        int i = start;

        while (tempStart <= mid && tempEnd <= end) {
            //if the start is less than the end
            if (tempArray[tempStart] <= tempArray[tempEnd]) {
                //copy the left into the temp array
                A[i] = tempArray[tempStart];
                tempStart++;
                comparisonCount++;
            } else {
                //otherwise copy the end into the temp array
                A[i] = tempArray[tempEnd];
                tempEnd++;
            }
            i++;
        }

        int index = mid - tempStart;
        //copy elements back into array
        for (int j = 0; j <= index; j++) {
            A[i + j] = tempArray[tempStart + j];
        }
    }

    /**
     * use mergesort to sort the subarray A[start..end]
     */
    public void mergeSort(int[] A, int start, int end) {
        //find middle so I can sort the first and second halves.
        if (start < end) {
            int middle = ((start + end) / 2);
            mergeSort(A, start, middle);
            mergeSort(A, middle + 1, end);
            merge(A, start, middle, end);
        }
    }

/**************************************************************************************/
    /**
     * sort A using LSD radix sort using radix of 10
     * use either counting sort or queue B to sort on each digit
     */
    public void radixSort(int[] A, int maxValue) {
        //Counting-Sort
        //let B[0...maxValue] be a new array
        int B[] = new int[maxValue + 1];

        //Make array B contain the same elements as array A
        for (int i : A) {
            B[i]++;
        }

        //sort the array
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            while (0 < B[i]) {
                A[index++] = i;
                B[i]--;
            }
        }
    }

    /************************************************************************************/
    /* Below find a couple of helper methods you may find useful: */

    /* swap A[i] and A[j]
     *  pre: 0 < i, j < A.size
     *  post: values in a[i] and a[j] are swapped */
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /* return the 10^d's place digit of n
     * e.g. getDigit(123,0) => 3 (1's place)
     *      getDigit(123,1) => 2 (10's place)
     *      getDigit(123,2) => 1 (100's place) */
    private int getDigit(int n, int d) {
        return (n / ((int) Math.pow(10, d))) % 10;
    }
}
