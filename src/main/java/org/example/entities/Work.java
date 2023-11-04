package org.example.entities;

import java.util.Random;

public class Work {
  private static final Random random = new Random();
  final WorkType type;
  final int duration;

  public enum WorkType {
    FIX_BUGS,
    WRITE_SOME_CODE,
    READ_DOCUMENTATION,
    GOOGLE_A_PROBLEM,
    DROP_DATABASE,
    EMAIL_TO_SUPPORT,
    ANSWER_STACKOVERFLOW_QUESTION,
  }

  private static final WorkType[] WORK_TYPES_VALUES = WorkType.values();

  private static WorkType getRandomWorkType() {
    return WORK_TYPES_VALUES[random.nextInt(WORK_TYPES_VALUES.length)];
  }

  public static Work generateRandomWork() {
    return new Work(getRandomWorkType(), random.nextInt(2900) + 100);
  }

  public Work(WorkType type, int duration) {
    this.type = type;
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Work{" + "type=" + type + ", duration=" + duration + '}';
  }
}
