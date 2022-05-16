import java.util.ArrayList;

public abstract class Scheduler {

  public ArrayList<Process> allProcesses = new ArrayList<Process>(); // processos iniciais
  public ArrayList<Process> newProcesses = new ArrayList<Process>();
  public ArrayList<Process> readyProcesses = new ArrayList<Process>();
  public ArrayList<Process> blockProcesses = new ArrayList<Process>();
  public ArrayList<Process> finishProcesses = new ArrayList<Process>();
  public Process currProc;

  public abstract void newToReady(int cicloAtual);

  public abstract void readyToRunning(int cicloAtual);

  public abstract void runningToBlocked(int cicloAtual);

  public abstract void runningToExitOrReady(int cicloAtual);

  public abstract void addProcess(Process p);

  public abstract void removeProcess(int p);

  // public abstract void setScheduler(Scheduler sm, int q);

  public abstract void printArrivalTimes();

  // public abstract void blockProcess(Process p);
}
