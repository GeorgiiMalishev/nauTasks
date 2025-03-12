package com.orgmange;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProcessor implements Task {
    private final Queue<String> queue = new LinkedList<>();
    private boolean stopped = false;

    @Override
    public void start() {
        System.out.println("Выполнение запущено");
        stopped = false;
        while (!stopped && !queue.isEmpty()) {
            String data = queue.poll();
            System.out.println("Processing data: " + data);
        }
    }

    @Override
    public void stop() {
        System.out.println("Выполнение остановлено");
        stopped = true;
    }

    private void addData(String data) {
        queue.offer(data);
    }

    public void run(){
        QueueProcessor task = new QueueProcessor();
        task.addData("Task 1");
        task.addData("Task 2");
        task.start();
        task.stop();
        task.addData("Task 3");
        task.addData("Task 4");
        task.start();
    }
}

