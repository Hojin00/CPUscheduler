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
  Scheduler sm;
  private int cicloAtual = 0;
  // maximumTime = 10;

  void execute() {
    System.out.println("Selecione a politica de escalonamento ");
    System.out.println("Digite 1 para priority e 2 para round robin");
    int nAlgoritmo = in.nextInt();

    // 1: priority
    // 2: round-robin
    int quantum;
    if (nAlgoritmo == 2) {
      System.out.print("quanto q eh o quantum? ");
      quantum = in.nextInt();
      // maximum = quantum * 2;
    }

    if (nAlgoritmo == 1) {
      sm = new Priority();
    } else {
      sm = new Round_Robin(quantum);
    }

    // montar processos
    while (readProcs) {
      readAllProcs();
    }

    sendProcsToScheduler();

    while (sm.newProcesses.size() >= 1 || sm.blockProcesses.size() >= 1 || sm.readyProcesses.size() >= 1) {
      if (sm.newProcesses.size() >= 1) {
        sm.newToReady(cicloAtual);
      }

      if (sm.readyProcesses.size() >= 1) {
        sm.readyToRunning(cicloAtual); // tem q implementar
      }

      if (sm.blockProcesses.size() >= 1) {
        sm.runningToBlocked(cicloAtual); // tem q implementar
      }

      this.cicloAtual++;

    }

  }

  private void sendProcsToScheduler() {
    for (int i = 0; i < allProcs.size(); i++) {
      sm.addProcess(allProcs.get(i));
    }
  }

  private void readAllProcs() {

    System.out.println("digite o nome do arquivo do processo? se n tiver mais processos digite S");
    String procPath = in.nextLine();
    rp.readProcess(procPath, memory);

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

      Process proc = new Process(id, priority, at);

      allProcs.add(proc);
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
