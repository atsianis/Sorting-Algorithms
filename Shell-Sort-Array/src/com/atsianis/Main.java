package com.atsianis;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        // first loop responsible for the manipulation of the gap
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            // inside loop responsible for keeping track of the new element's index
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                // initializing the comparison index as the new element's index
                int j = i;
                // as long as we haven't hit the front of the array
                // and we keep finding bigger values at lower indexes
                // then the comparison must continue
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                // we found the insertion index
                intArray[j] = newElement;
            }
        }
    }
}
