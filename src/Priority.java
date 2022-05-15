import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Priority extends Scheduler {

  public ArrayList<Process> allProcesses = new ArrayList<Process>(); // processos iniciais
  public ArrayList<Process> newProcesses = new ArrayList<Process>();
  public ArrayList<Process> readyProcesses = new ArrayList<Process>();
  public ArrayList<Process> blockProcesses = new ArrayList<Process>();
  public ArrayList<Process> finishProcesses = new ArrayList<Process>();
  public Process currProc;

  @Override
  public void newToReady(int cicloAtual) {
    for (int i = 0; i < newProcesses.size(); i++) {
      if (cicloAtual == newProcesses.get(i).getArrivalTime()) {
        readyProcesses.add(newProcesses.get(i));
        newProcesses.get(i).setState("Ready");
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
    // TODO Auto-generated method stub
    allProcesses.add(p);
  }

  // public void organizeProcesses() {
  // ArrayList<int> aux = new ArrayList<int>();

  // for (int i = 0; i < readyProcesses.size() - 1; i++) {
  // if (aux.size() == 0) {
  // aux.add(readyProcesses.get(i));
  // continue;
  // }
  // for (int j = 0; j < readyProcesses.size() - 1; j++) {
  // if (readyProcesses.get(i).getPriority() > aux.get(j).getPriority()) {
  // aux.add(j, readyProcesses.get(i));
  // }
  // }
  // }

  // for (Process p : aux) {
  // System.out.println(p.getPriority());
  // }
  // // System.out.println(aux.toString());
  // // return aux;
  // }
  public void sortReadyList() {
    Collections.sort(readyProcesses, Comparator.comparing(Process::getPriority));
    Collections.reverse(readyProcesses);

  }

  /*
   * @Override
   * public int compare(Process o1, Process o2) {
   * return (o1.getPriority() >= o2.getPriority()) ? 1 : -1;
   * }
   */

  @Override
  public void removeProcess(int p) {

  }

  @Override
  public void printArrivalTimes() {

    for (Process p : allProcesses) {
      System.out.println(p.getArrivalTime());
    }

  }

}