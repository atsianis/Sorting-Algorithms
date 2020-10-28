package com.atsianis;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int largest;
        for(int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            largest = 0;
            for(int i = 1; i <= lastUnsortedIndex; i++){
                if (intArray[i] > intArray[largest]){
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }

        //print the array
//        Arrays.stream(intArray).sequential().forEach(System.out::println);
        for(int i : intArray)
            System.out.println(i);
    }

    static void swap (int[] array, int i, int j){
        if (i==j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
