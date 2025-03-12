package com.orgmange;

import java.util.Arrays;
import java.util.Random;

public class LastPositiveFinder {
    private final int arrLength;

    public LastPositiveFinder(int arrLength) {
        this.arrLength = arrLength;
    }

    private int[] createArray(){
        Random random = new Random();
        int[] arr = new int[arrLength];
        for(int i = 0; i < arrLength; i++){
            arr[i] = random.nextInt();
        }

        return arr;
    }

    private int findLastPositive(int[] array){
        for(int i = array.length-1; i >= 0; i--){
            if(array[i] > 0)
                return array[i];
        }
        return -1;
    }

    public void run(){
        int[] arr = createArray();
        int lastPositive = findLastPositive(arr);
        String answer = lastPositive == -1
                ? "Положительных числе в массиве нет!"
                : "Последнее положительное число: " + lastPositive;

        System.out.println("Исходный массив: "
                + Arrays.toString(arr)
                + "\n"
                + answer);
    }
}
