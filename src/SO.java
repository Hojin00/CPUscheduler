import java.util.Scanner;
import java.util.ArrayList;
//import javax.annotation.processing.Processor;

public class SO {
  public String[] memory;
  public ArrayList<Process> allProcs = new ArrayList<Process>();
  Scanner in = new Scanner(System.in);

  private void execute() {

    System.out.print("Digite 1 para priority e 2 para round robin :)");
    int nAlgoritmo = in.nextInt();
    // 1: priority
    // 2: round-robin
    int quantum;
    if (nAlgoritmo == 2) {
      System.out.print("quanto q eh o quantum? ");
      quantum = in.nextInt();
    }
      
    // receber input do usuario :)
    
    String schedulerType;
    if (nAlgoritmo == 1):
      schedulerType = "Priority";
    else:
      schedulerType = "Round-Robin";
      
    readAllProcs();
    
    CPU cpu = new CPU(allProcs, schedulerType, quantum);
  }

  private void readAllProcs(String filename) {

    System.out.println("qual e o prioridade deste processo? ");
    // 1: baixa
    // 2: media
    // 3: alta
    Process p = new Process();
    allProcs.add(p);

  }

  public abstract void keepTrackOfState(Process p);

}

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
