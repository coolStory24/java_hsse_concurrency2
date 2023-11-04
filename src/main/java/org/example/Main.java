package org.example;

import org.example.entities.Manager;
import org.example.entities.Producer;
import org.example.entities.Worker;
import org.example.threads.ManagerThread;
import org.example.threads.ProducerThread;
import org.example.threads.WorkerThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    var manager = new Manager("John");
    var producer1 = new Producer("Simon", manager);
    var producer2 = new Producer("Richard", manager);
    var worker1 = new Worker("Ben", manager);
    var worker2 = new Worker("Sven", manager);
    var worker3 = new Worker("Jack", manager);
    var worker4 = new Worker("Austin", manager);

    var executor = Executors.newCachedThreadPool();
    var latch = new CountDownLatch(10);

    executor.submit(new ManagerThread(manager, latch));
    executor.submit(new ProducerThread(producer1));
    executor.submit(new ProducerThread(producer2));
    executor.submit(new WorkerThread(worker1));
    executor.submit(new WorkerThread(worker2));
    executor.submit(new WorkerThread(worker3));

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.HOURS);
  }
}
