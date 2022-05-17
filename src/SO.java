import java.util.Scanner;
import java.util.ArrayList;
//import javax.annotation.processing.Processor;

public class SO {
  public String[] memory;
  public String[] copyMemory;
  public ArrayList<Process> allProcs = new ArrayList<Process>();
  public boolean readProcs = true;
  Scanner in = new Scanner(System.in);
  private int quantum = 0;
  private int id = 0;
  ReaderProcs rp = new ReaderProcs();
  Priority priority;
  Round_Robin rr;
  private int cicloAtual = 0;

  // maximumTime = 10;

  void execute() {
    System.out.println("Selecione a politica de escalonamento ");
    System.out.println("Digite 1 para priority e 2 para round robin\n");
    int nAlgoritmo = in.nextInt();

    // 1: priority
    // 2: round-robin
    if (nAlgoritmo == 2) {
      System.out.print("quanto q eh o quantum? ");
      quantum = in.nextInt();
      // maximum = quantum * 2;
    }

    if (nAlgoritmo == 1) {
      priority = new Priority();
    } else {
      rr = new Round_Robin(quantum);
    }

    // montar processos
    // while (readProcs) {
    // readAllProcs();
    // }

    Process mockproc1 = new Process(1, 1, 0, 4);
    Process mockproc2 = new Process(2, 2, 0, 3);
    Process mockproc3 = new Process(3, 1, 6, 7);
    Process mockproc4 = new Process(4, 3, 11, 4);
    Process mockproc5 = new Process(5, 2, 12, 2);

    allProcs.add(mockproc1);
    allProcs.add(mockproc2);
    allProcs.add(mockproc3);
    allProcs.add(mockproc4);
    allProcs.add(mockproc5);

    if (nAlgoritmo == 1) {
      priority = new Priority();

      sendProcsTopPriority();

      while (this.priority.newProcesses.size() >= 1 || this.priority.blockProcesses.size() >= 1
          || this.priority.readyProcesses.size() >= 1 || this.priority.currProc != null) {
        if (priority.currProc != null) {
          priority.runningToExitOrReady(cicloAtual); // tem q implementar
        }

        if (priority.newProcesses.size() >= 1) {
          priority.newToReady(cicloAtual);
        }

        if (priority.readyProcesses.size() >= 1 && priority.currProc == null) {
          priority.readyToRunning(cicloAtual); // tem q implementar
        }

        if (priority.blockProcesses.size() >= 1) {
          priority.runningToBlocked(cicloAtual); // tem q implementar
        }

        this.cicloAtual++;
        if (priority.currProc != null) {
          this.priority.currProc.tempoDeExecucaoTotal++;
          this.priority.currProc.tempoRestante++;
        }
      }
      for(int i = 0; i < priority.finishProcesses.size(); i++) {
        System.out.println("PID: " + priority.finishProcesses.get(i).getPID() + "-" + "Processing Time: " + priority.finishProcesses.get(i).tempoDeExecucaoTotal + " WT: " + priority.finishProcesses.get(i).wt + " TT: " + (priority.finishProcesses.get(i).processTime + priority.finishProcesses.get(i).wt));
      }
    } else {
      rr = new Round_Robin(quantum);

      sendProcsTopRR();

      while (this.rr.newProcesses.size() >= 1 || this.rr.blockProcesses.size() >= 1
          || this.rr.readyProcesses.size() >= 1 || this.rr.currProc != null) {
        if (rr.currProc != null) {
          rr.runningToExitOrReady(cicloAtual); // tem q implementar
        }

        if (rr.newProcesses.size() >= 1) {
          rr.newToReady(cicloAtual);
        }

        if (rr.readyProcesses.size() >= 1 && rr.currProc == null) {
          rr.readyToRunning(cicloAtual); // tem q implementar
        }

        if (rr.blockProcesses.size() >= 1) {
          rr.runningToBlocked(cicloAtual); // tem q implementar
        }

        this.cicloAtual++;
        if (rr.currProc != null) {
          this.rr.currProc.tempoDeExecucaoTotal++;
          this.rr.currProc.tempoRestante++;
        }
      }
      for(int i = 0; i < rr.finishProcesses.size(); i++) {
        System.out.println("PID: " + rr.finishProcesses.get(i).getPID() + "-" + "Processing Time: " + rr.finishProcesses.get(i).tempoDeExecucaoTotal + " WT: " + rr.finishProcesses.get(i).wt + " TT: " + (rr.finishProcesses.get(i).processTime + rr.finishProcesses.get(i).wt));
      }
    }
  }

  private void sendProcsTopPriority() {
    for (int i = 0; i < allProcs.size(); i++) {
      priority.newProcesses.add(allProcs.get(i));
    }
    System.out.println(" size " + this.priority.newProcesses.size());
  }

  private void sendProcsTopRR() {
    for (int i = 0; i < allProcs.size(); i++) {
      rr.newProcesses.add(allProcs.get(i));
    }
    System.out.println(" size " + this.rr.newProcesses.size());
  }

  private void readAllProcs() {

    System.out.println("digite o nome do arquivo do processo? se n tiver mais processos digite S");
    String procPath = in.nextLine();
    // rp.readFile(filename, proc, memory, posicaoMemoria);

    if (procPath.equals("S")) {
      readProcs = false;
    } else {
      // Bufferreader ou Scanner para achar o txt(processo)
      System.out.println("digite arrival time do processo");
      int at = in.nextInt();

      System.out.println("qual e o prioridade do processo? ");
      // priority = in.nextInt();
      // 1: baixa
      // 2: media
      // 3: alta

      // Process proc = new Process(id, priority, at);

      // allProcs.add(proc);
      id++;
    }

  }

}
// public abstract void keepTrackOfState(Process p);return p.getState();

// allProc: [Process]
// memoria: [String]
// lerArquivo()
// for i
// allproc.add(p)
// memoria.add(p.instrucoes)

// executeProgram()
// instancia processos
// instancia scheduler
// sm.start()

// So

// // tem controle em todas as listas de todos os estados
// // alocacao de memoria
// // cria pcb do processo
// // tem funcao gerenciaProcesso()
// // quando aquele processo efetivamente vai ser liberado
// // SO lança o processo pro estado de ready olhando o arrivaltime
// CPU Scheduler-round-robin tambem
// considera prioridade

// problema de
// algums processos
// com alta
// prioridade continuam
// ocupando a
// lista de ready-
// processos com
// media prioridade
// sempre ficam
// na lista
// de suspend, pq
// alta prirodiade
// sempre ganham
// espaco de
// lista de
// ready
