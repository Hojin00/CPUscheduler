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
  public CPU cpu = new CPU();
  public int timeout = 3;

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
    if ((currProc.processTime - currProc.tempoRestante == timeout)
        && (currProc.tempoDeExecucaoTotal < currProc.processTime)) {
      currProc.tempoRestante -= currProc.stopExecutingTime - currProc.startExecutingTime;
      readyProcesses.add(currProc);
      currProc = null;

    } else if (currProc.tempoDeExecucaoTotal == currProc.processTime) {
      System.out.println("ID." + currProc.getPID() + " entrou no exit :" + " ciclo inicial ---> "
          + currProc.startExecutingTime + " ciclo final ---> " + cicloAtual);
      finishProcesses.add(currProc);
      currProc.setPc(cpu.getPc());
      currProc.setAcc(cpu.getAcc());
      currProc = null;

    } else {
      currProc.tempoRestante--;
    }
  }

  @Override
  public void addProcess(Process p) {
    // TODO Auto-generated method stub
    newProcesses.add(p);
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