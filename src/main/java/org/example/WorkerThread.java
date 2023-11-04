package org.example;

import org.example.exceptions.WorkerInterruptedException;

import java.util.logging.Logger;

public class WorkerThread implements Runnable {

  private final Worker worker;

  public WorkerThread(Worker worker) {
    this.worker = worker;
  }

  @Override
  public void run() {
    while (worker.getIsWorking()) {
      try {
        worker.work();
      } catch (InterruptedException e) {
        throw new WorkerInterruptedException();
      }
    }

  }
}
