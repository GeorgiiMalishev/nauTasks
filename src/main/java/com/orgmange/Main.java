package com.orgmange;

public class Main {
    public static void main(String[] args) {
        LastPositiveFinder lastPositiveFinder = new LastPositiveFinder(10);
        lastPositiveFinder.run();

        SelectionSort selectionSort = new SelectionSort(10);
        selectionSort.run();

        FormatEmployees formatEmployees = new FormatEmployees();
        formatEmployees.run();

        AcceptHeadersParser acceptHeadersParser = new AcceptHeadersParser();
        acceptHeadersParser.run();

        QueueProcessor queueProcessor = new QueueProcessor();
        queueProcessor.run();
        }
    }