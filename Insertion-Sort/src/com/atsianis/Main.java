package com.atsianis;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length - 1; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            // traversing the sorted part of the array
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                // shifting
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
    }
}
