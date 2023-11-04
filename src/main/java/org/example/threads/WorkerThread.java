package org.example.threads;

import org.example.entities.Worker;
import org.example.exceptions.WorkerInterruptedException;

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
