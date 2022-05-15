public class Process {
  private int pid;
  private int pc;
  private int acc;
  private String state;
  private int priority = 0;
  private int arrivalTime = 0;
  public int tempoDeExecucaoAtual = 0; // qnt ciclo de unidade de execucao passou ate agora
  // public int unidadeDoTempo = 0;

  private boolean isActive = false;
  private boolean isArrived = false;
  private boolean isStarted = false;
  private boolean isFinished = false;

  Process(int id, int priority, int arrivalTime) {
    this.pid = id;
    this.pc = 0;
    this.acc = 0;
    this.state = "New";
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

  public void setState(String state) {
    this.state = state;
  }

  // executing()
  //

}
