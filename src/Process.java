public class Process {
  private int pid;
  private int pc;
  private int acc;
  private String state;
  private int priority = 0;
  private double arrivalTime;

  private boolean isActive = false;
  private boolean isArrived = false;
  private boolean isStarted = false;
  private boolean isFinished = false;

  Process(int priority) {
    this.pid = 0;
    this.pc = 0;
    this.acc = 0;
    this.arrivalTime = 0;
    this.priority = priority;
  }

  Process(int pid, int pc, int acc, double arrivalTime, int priority) {
    this.pid = pid;
    this.pc = pc;
    this.acc = acc;
    this.arrivalTime = arrivalTime;
    this.priority = priority;
  }

  public double getArrivalTime() {
    return arrivalTime;
  }

  public int getPriority() {
    return priority;
  }

  // executing()
  //

}
