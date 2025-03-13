package com.orgmange;

public class Main {
    public static void main(String[] args) {
        var lastPositiveFinder = new LastPositiveFinder(10);
        lastPositiveFinder.run();

        var selectionSort = new SelectionSort(10);
        selectionSort.run();

        var formatEmployees = new FormatEmployees();
        formatEmployees.run();

        var acceptHeadersParser = new AcceptHeadersParser();
        acceptHeadersParser.run();

        var queueProcessor = new QueueProcessor();
        queueProcessor.run();
        }
    }