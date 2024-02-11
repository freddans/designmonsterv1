package exercises.adapter.classes;

import exercises.adapter.interfaces.Logger;

import java.util.Date;

public class LoggerAdapter implements Logger {
  // var
  private String name = "LoggerAdapter";
  CandidateLogger newLoggerSystem = new CandidateLogger();

  // Methods
  @Override
  public void log(String str) {
    System.out.println("FROM: LoggerAdapter -> CandidateLogger.log");
    newLoggerSystem.log(str, new Date());
  }

  // Getters and Setters
  public String getName() {
    return name;
  }
}
