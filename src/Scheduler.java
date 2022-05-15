import java.util.ArrayList;

public abstract class Scheduler {

  public ArrayList<Process> allProcesses;
  public ArrayList<Process> newProcesses;
  public ArrayList<Process> readyProcesses;
  public ArrayList<Process> blockProcesses;
  public ArrayList<Process> finishProcesses;
  public Process currProc;

  public abstract void newToReady(int cicloAtual);

  public abstract void readyToRunning(int cicloAtual);

  public abstract void runningToBlocked(int cicloAtual);

  public abstract void addProcess(Process p);

  public abstract void removeProcess(int p);

  // public abstract void setScheduler(Scheduler sm, int q);

  public abstract void printArrivalTimes();

  // public abstract void blockProcess(Process p);
}
