public abstract class Scheduler {

  public abstract void addProcess(Process p);

  public abstract void removeProcess(int p);

  public abstract void setScheduler(Scheduler sm);

  public abstract void printArrivalTimes();

  // public abstract void blockProcess(Process p);
}
