package org.example;

import org.example.exceptions.WorkerInterruptedException;

import java.util.concurrent.CountDownLatch;

public class ManagerThread implements Runnable{
  private final Manager manager;
  private final CountDownLatch latch;

  public ManagerThread(Manager manager, CountDownLatch latch) {
    this.manager = manager;
    this.latch = latch;
  }

  @Override
  public void run() {
    manager.startWorking();
    while (latch.getCount() > 0) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new WorkerInterruptedException();
      }
      latch.countDown();
    }
    manager.stopWorking();
  }
}
