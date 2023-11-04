package org.example;

import org.example.interfaces.Working;

import java.util.logging.Logger;

public class Producer implements Working {
  private static final Logger logger = Logger.getLogger(Producer.class.getSimpleName());
  public final String name;
  private final Manager manager;

  public Producer(String name, Manager manager) {
    this.name = name;
    this.manager = manager;
  }

  public void createTask() {
    this.manager.addWork(Work.generateRandomWork());
    logger.info("New task added by " + name);
  }

  public boolean getIsWorking() {
    return manager.getIsWorking();
  }
}
