package org.example;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import org.example.exceptions.NoWorkAvailableException;
import org.example.interfaces.Working;

public class Manager implements Working {
  private static final Logger logger = Logger.getLogger(Producer.class.getSimpleName());
  public final String name;
  private final LinkedBlockingQueue<Work> workToDo = new LinkedBlockingQueue<>();
  private final AtomicBoolean isWorking = new AtomicBoolean(true);

  public Manager(String name) {
    this.name = name;
  }

  synchronized Work getWork() throws NoWorkAvailableException, InterruptedException {
      if (workToDo.isEmpty()) throw new NoWorkAvailableException();
      return workToDo.take();
  }

  public void addWork(Work work) {
    workToDo.add(work);
  }

  public void startWorking() {
    isWorking.set(true);
    logger.info("The working day starts!");
  }

  public synchronized void stopWorking() {
    isWorking.set(false);
    logger.info("The working day ends!!!");
  }

  public boolean getIsWorking() {
    return isWorking.get();
  }
}
