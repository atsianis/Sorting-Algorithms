package com.atsianis;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray,0,intArray.length);

        Arrays.stream(intArray).forEach(System.out::println);


    }

    public static void mergeSort(int[] inputArray, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(inputArray, start, mid);
        mergeSort(inputArray, mid, end);
        merge(inputArray, start, mid, end);
    }

    public static void merge(int[] inputArray, int start, int mid, int end) {
        // if the last element of the left array is < than the first element
        // of the right array, then we don't need to continue
        // the two sub-arrays are already sorted
        // there is no need to create a temporary array, it would be redundant
        if (inputArray[mid - 1] <= inputArray[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int temp[] = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = inputArray[i] <= inputArray[j] ? inputArray[i++] : inputArray[j++];
        }
        // Handling leftover elements in the 2 sun-arrays:
        //  if we have elements remaining in the right array, we don't have to worry
        //  because their position in the original array won't change
        //  ex. merging {12,14} and {10,17}
        //  BUT if we have remaining element in the left array we have to make sure that they are added
        //  in the temp array because their positions in the original array need to change
        //  ex. merging {11,20} and {9,15}

        // Because we already know the positions of those leftovers in the left array
        // we can skip the copying in the temp array and directly copy them in the original array
        // in their appropriate positions
        System.arraycopy(inputArray, i, inputArray, start + tempIndex, mid - i);

        // Copying the temp array to original array
        System.arraycopy(temp, 0, inputArray, start, tempIndex);

    }
}
