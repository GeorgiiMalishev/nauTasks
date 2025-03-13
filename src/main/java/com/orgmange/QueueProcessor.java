package com.orgmange;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueueProcessor implements Task {
    private final Queue<String> queue = new LinkedList<>();
    private final AtomicBoolean stopped = new AtomicBoolean(false);

    @Override
    public void start() {
        System.out.println("Выполнение запущено");
        stopped.set(false);
        Thread thread = new Thread(()-> {
            while (!stopped.get() && !queue.isEmpty()) {
            String data = queue.poll();
            System.out.println("Processing data: " + data);
        }});
        thread.start();
    }

    @Override
    public void stop() {
        stopped.set(true);
        System.out.println("Выполнение остановлено");
    }

    public void addData(String data) {
        queue.offer(data);
    }

    public void run(){
        QueueProcessor task = new QueueProcessor();
        task.addData("Task 1");
        task.addData("Task 2");
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        task.stop();
        task.addData("Task 3");
        task.addData("Task 4");
        task.start();
    }
}

