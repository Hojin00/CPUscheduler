import java.util.ArrayList;
import java.util.Comparator;

public class Priority extends Scheduler {

  private ArrayList<Process> processes = new ArrayList<Process>();

  @Override
  public void addProcess(Process p) {
    // TODO Auto-generated method stub
    processes.add(p);

  }

  public void organizeProcesses() {
    ArrayList<Process> aux = new ArrayList<Process>();

    for (int i = 0; i < processes.size() - 1; i++) {
      if (aux.size() == 0) {
        aux.add(processes.get(i));
        continue;
      }
      for (int j = i; j < processes.size() - 1; j++) {
        if (processes.get(i).getPriority() > aux.get(j).getPriority()) {
          aux.add(j, processes.get(i));
        }
      }
    }

    for (Process p : aux) {
      System.out.println(p.getPriority());
    }
    // System.out.println(aux.toString());
    // return aux;
  }

  /*
   * @Override
   * public int compare(Process o1, Process o2) {
   * return (o1.getPriority() >= o2.getPriority()) ? 1 : -1;
   * }
   */

  @Override
  public void removeProcess(int p) {
    // TODO Auto-generated method stub

  }

  @Override
  public void printArrivalTimes() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setScheduler(Scheduler sm) {

  }

  // @Override
}