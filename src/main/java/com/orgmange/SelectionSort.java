package com.orgmange;

import java.util.*;

public class SelectionSort {
    private final int listSize;

    public SelectionSort(int listSize) {
        this.listSize = listSize;
    }

    private List<Double> createList(){
        Random random = new Random();
        List<Double> list = new ArrayList<>(listSize);
        for(int i = 0; i < listSize; i++){
           list.add(random.nextDouble());
        }

        return list;
    }

    private List<Double> sort(List<Double> list){
        List<Double> listCopy = new ArrayList<>(list);
        for(int i = 0; i < listCopy.size(); i++){
            int localMinIndex = i;
            for(int j = i+1; j < listCopy.size(); j++){
                if(listCopy.get(localMinIndex) > listCopy.get(j))
                    localMinIndex = j;
            }
            Collections.swap(listCopy, i, localMinIndex);
        }

        return listCopy;
    }

    public void run(){
        List<Double> list = createList();
        System.out.println("Исходный список: "
                + list + "\n"
                + "Отсортированный список: "
                + sort(list));
    }
}
