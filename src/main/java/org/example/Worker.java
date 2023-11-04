package org.example;

import java.util.logging.Logger;
import org.example.exceptions.NoWorkAvailableException;
import org.example.interfaces.Working;

public class Worker implements Working {
  private static final Logger logger = Logger.getLogger(Worker.class.getSimpleName());
  public final String name;
  public final Manager manager;

  public Worker(String name, Manager manager) {
    this.name = name;
    this.manager = manager;
  }

  public synchronized void work() throws InterruptedException {
    try{
      var work = manager.getWork();
      Thread.sleep(work.duration);

      logger.info(work + " successfully done by " + name);
    } catch (NoWorkAvailableException e) {
      logger.info("No work available for " + name +". It's time for coffee break");
      Thread.sleep(1000);
    }
  }


  @Override
  public boolean getIsWorking() {
    return manager.getIsWorking();
  }
}
