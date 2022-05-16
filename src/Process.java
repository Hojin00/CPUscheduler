public class Process {
  private int pid;
  private int pc;
  private int acc;
  private String state;
  private int priority = 0;
  private int arrivalTime = 0;
  public int startExecutingTime = 0;
  public int stopExecutingTime = 0;
  public int processTime = 0; // 4
  public int tempoRestante = 0; // 1
  public int tempoDeExecucaoTotal = 0; // 3 // qnt ciclo de unidade total de execucao passou ate agora
  // public int unidadeDoTempo = 0;

  private int programStart;
  private int programEnd;
  private int varStart;
  private int varEnd;

  Process(int id, int priority, int arrivalTime, int processTime) {
    this.pid = id;
    this.pc = 0;
    this.acc = 0;
    this.state = "New";
    this.processTime = processTime;
    this.tempoRestante = this.processTime;
    this.arrivalTime = arrivalTime;
    this.priority = priority;
  }

  public int getPID() {
    return pid;
  }

  public int getPc() {
    return pc;
  }

  public int getAcc() {
    return acc;
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

  public double getArrivalTime() {
    return arrivalTime;
  }

  public int getPriority() {
    return priority;
  }

  public void setProgramEnd(int n) {
    programEnd = n;
  }

  public void setProgramStart(int n) {
    programStart = n;
  }

  public void setVarStart(int n) {
    varStart = n;
  }

  public void setVarEnd(int n) {
    varEnd = n;
  }

  public int getProgramStart() {
    return programStart;
  }

  public int getProgramEnd() {
    return programEnd;
  }

  public int getVarStart() {
    return varStart;
  }

  public int getVarEnd() {
    return varEnd;
  }

  // executing()
  //

}
