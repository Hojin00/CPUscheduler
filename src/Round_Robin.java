import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Round_Robin extends Scheduler {

  public double quantum;
  public ArrayList<Process> allProcesses = new ArrayList<Process>(); // processos iniciais
  public ArrayList<Process> newProcesses = new ArrayList<Process>();
  public ArrayList<Process> readyProcesses = new ArrayList<Process>();
  public ArrayList<Process> blockProcesses = new ArrayList<Process>();
  public ArrayList<Process> finishProcesses = new ArrayList<Process>();
  public Process currProc;
  public CPU cpu = new CPU();

  Round_Robin(double q) {

    quantum = q;
    // rrList = new ArrayList<Process>();
    // quantum = q;
    // curTimeQuantum = 0.0;
    // activeProc = null;
    // currProc = 0;
  }

  @Override
  public void newToReady(int cicloAtual) {
    int cont = 0;
    while (newProcesses.size() >= 1) {
      if (cont == newProcesses.size()) {
        break;
      }
      if (cicloAtual == newProcesses.get(cont).getArrivalTime()) {
        readyProcesses.add(newProcesses.get(cont));
        newProcesses.get(cont).setState("Ready");
        System.out.println("ID." + newProcesses.get(cont).getPID() +
            " entrou no ready : " + " ciclo atual ---> " + cicloAtual);
        cont = 0;
        newProcesses.remove(cont);
      } else {
        cont++;
      }
    }
  }

  @Override
  public void readyToRunning(int cicloAtual) {
    sortReadyList();
    currProc = readyProcesses.get(0);
    currProc.startExecutingTime = cicloAtual;
    cpu.setProcessinProcessor(currProc); // currProc vai usar cpu
    currProc.setState("Running");
    readyProcesses.remove(0);
    System.out.println("ID." + currProc.getPID() + " entrou no running :" + " ciclo atual ---> " + cicloAtual);
  }

  @Override
  public void runningToBlocked(int cicloAtual) {
    currProc.stopExecutingTime = cicloAtual;
    currProc.tempoDeExecucaoTotal += currProc.stopExecutingTime - currProc.startExecutingTime;
    currProc.setPc(cpu.getPc());
    currProc.setAcc(cpu.getAcc());
    currProc.setState("Blocked");
    System.out.println(
        "ID." + currProc.getPID() + " entrou no blocked :" + " ultimo ciclo ---> " + cicloAtual);
    blockProcesses.add(currProc);
    currProc = null;
  }

  @Override
  public void runningToExitOrReady(int cicloAtual) {
    // TODO Auto-generated method stub
    if (currProc.tempoDeExecucaoTotal == currProc.processTime) {
      System.out.println("ID." + currProc.getPID() + " entrou no exit :" + " ciclo inicial ---> "
          + currProc.startExecutingTime + " ciclo final ---> " + cicloAtual);
      finishProcesses.add(currProc);
      currProc.setPc(cpu.getPc());
      currProc.setAcc(cpu.getAcc());
      currProc = null;

    }

  }

  @Override
  public void addProcess(Process p) {
    // TODO Auto-generated method stub
    newProcesses.add(p);
  }

  public void sortReadyList() {
    Collections.sort(readyProcesses, Comparator.comparing(Process::getPriority));
    Collections.reverse(readyProcesses);

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
