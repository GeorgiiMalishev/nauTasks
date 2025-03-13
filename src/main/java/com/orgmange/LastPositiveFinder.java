package com.orgmange;

import java.util.Arrays;
import java.util.Optional;
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

    private Optional<Integer> findLastPositive(int[] array){
        for(int i = array.length-1; i >= 0; i--){
            if(array[i] > 0)
                return Optional.of(array[i]);
        }
        return Optional.empty();
    }

    public void run(){
        int[] arr = createArray();
        Optional<Integer> lastPositive = findLastPositive(arr);
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        if(lastPositive.isEmpty())
            System.out.println("Положительных числе в массиве нет!");
        else
            System.out.println("Последнее положительное число: " + lastPositive.get());

    }
}
