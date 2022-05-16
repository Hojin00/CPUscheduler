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
  private int priority = 0;
  private int id = 0;
  ReaderProcs rp = new ReaderProcs();
  Priority sm;
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
      sm = new Priority();
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

    sendProcsToScheduler();

    while (this.sm.newProcesses.size() >= 1 || this.sm.blockProcesses.size() >= 1
        || this.sm.readyProcesses.size() >= 1) {
      if (sm.currProc != null) {
        sm.runningToExitOrReady(cicloAtual); // tem q implementar
      }

      if (sm.newProcesses.size() >= 1) {
        sm.newToReady(cicloAtual);
      }

      if (sm.readyProcesses.size() >= 1 && sm.currProc == null) {
        sm.readyToRunning(cicloAtual); // tem q implementar
      }

      if (sm.blockProcesses.size() >= 1) {
        sm.runningToBlocked(cicloAtual); // tem q implementar
      }

      this.cicloAtual++;
      this.sm.currProc.tempoDeExecucaoTotal++;

    }
  }

  private void sendProcsToScheduler() {
    for (int i = 0; i < allProcs.size(); i++) {
      sm.newProcesses.add(allProcs.get(i));
    }
    System.out.println(" size " + this.sm.newProcesses.size());
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
      priority = in.nextInt();
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
