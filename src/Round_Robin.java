import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Round_Robin extends Scheduler {

  public double quantum;
  public ArrayList<Process> allProcesses = new ArrayList<Process>();
  public ArrayList<Process> newProcesses = new ArrayList<Process>();
  public PriorityQueue<Process> readyProcesses;
  public ArrayList<Process> blockProcesses = new ArrayList<Process>();
  public ArrayList<Process> finishProcesses = new ArrayList<Process>();
  public ArrayList<Process> rrList;
  public Process currProc;

  Round_Robin(double q) {
    readyProcesses = new PriorityQueue<Process>(new Comparator<Process>() {
      @Override
      public int compare(Process o1, Process o2) {
        return (o1.getArrivalTime() >= o2.getArrivalTime()) ? 1 : -1;
      }
    });
    quantum = q;
    // rrList = new ArrayList<Process>();
    // quantum = q;
    // curTimeQuantum = 0.0;
    // activeProc = null;
    // currProc = 0;
  }

  @Override
  public void newToReady(int cicloAtual) {
    for (int i = 0; i < newProcesses.size(); i++) {
      if (cicloAtual == newProcesses.get(i).getArrivalTime()) {
        readyProcesses.add(newProcesses.get(i));
        newProcesses.remove(i);
      }
    }
  }

  @Override
  public void runningToBlocked(int cicloAtual) {
    // TODO Auto-generated method stub
    currProc.setState("Blocked");
    currProc.tempoDeExecucaoAtual = cicloAtual;
    currProc.pc = CPU.pc;
    currProc.acc = CPU.acc;
  }

  @Override
  public void addProcess(Process p) {
    allProcesses.add(p);
  }

  @Override
  public void removeProcess(int p) {
    finishProcesses.add(newProcesses.get(p));
    newProcesses.remove(p);
  }

  @Override
  public void printArrivalTimes() {
    // Iterator<Process> itr = pq.iterator();
    // while (itr.hasNext()) {
    // System.out.println(((Process) itr).getArrivalTime());
    // }
    for (Process p : allProcesses) {
      System.out.println(p.getArrivalTime());
    }

  }

}
