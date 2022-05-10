import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Round_Robin extends Scheduler {

  private double quantum;
  ArrayList<Process> newProcesses;
  PriorityQueue<Process> readyProcesses;
  ArrayList<Process> blockProcesses;
  ArrayList<Process> finishProcesses;
  private ArrayList<Process> rrList;
  private int currProc;

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
  public void addProcess(Process p) {
    newProcesses.add(p);
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
    for (Process p : readyProcesses) {
      System.out.println(p.getArrivalTime());
    }

  }

  @Override
  public void setScheduler(Scheduler sm) {
    // TODO Auto-generated method stub
    If(n == 1)
  }

}
