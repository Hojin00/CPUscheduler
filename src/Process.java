public class Process {
  private int pid;
  private int pc;
  private int acc;
  private String state;
  private int priority = 0;
  private double arrivalTime = 0;

  private boolean isActive = false;
  private boolean isArrived = false;
  private boolean isStarted = false;
  private boolean isFinished = false;

  Process(int id, int priority, double arrivalTime) {
    this.pid = id;
    this.pc = 0;
    this.acc = 0;
    this.arrivalTime = arrivalTime;
    this.priority = priority;
  }

  public double getArrivalTime() {
    return arrivalTime;
  }

  public int getPriority() {
    return priority;
  }

  public String getState() {
    return state;
  }

  public void setPc(int n) {
    this.pc = n;
  }

  public void setAcc(int n) {
    this.acc = n;
  }

  // executing()
  //

}
