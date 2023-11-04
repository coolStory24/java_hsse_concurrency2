package org.example;

import org.example.exceptions.WorkerInterruptedException;

public class ProducerThread implements Runnable {
  private final Producer producer;

  public ProducerThread(Producer producer) {
    this.producer = producer;
  }

  @Override
  public void run() {
    while (producer.getIsWorking()) {
      producer.createTask();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new WorkerInterruptedException();
      }
    }
  }
}
