import java.util.ArrayList;

public class CPU {
  private Scheduler sm; // prioridade com preempcao ou nao ou round robin
  private int pc;
  private int acc;
  public Process activeProc;

  public void setProcessinProcessor(Process activeProc) {
    this.pc = activeProc.getPc();
    this.acc = activeProc.getAcc();
    this.activeProc = activeProc;
  }
  // for(p)
  // Processo p = new Process(pid, pc, acc, arrivalTime, priority);
  // allProcs.add(p);
  // }

  // sm.setScheduler() -> define o tipo de scheduler

  // var allProcs, procQueue (talvez), readyQueue, activeProc, preProc
  // setPCB(process p)
  // cpu.pc = p.pc
  // cpu.acc = p.acc

  // savePCB( processo p)
  // if sm.tipo == "roundrobin"
  // p.pc = cpu.pc
  // p.acc = cpu.acc
  // p.state = "bloqueado" ou "readyqueue"
  // if sm.tipo == 'priority'
  // p.pc = cppu.pc
  // p.acc =cpu.acc

  // processa(processo p)

  // assembly codes

  // setScheduler

  public static Scheduler setScheduler(String s, int q) {

    switch (s) {
      case "Priority":
        return new Priority();
      case "Round-Robin":
        return new Round_Robin(q);
    }
    return null;
  }

  public int getPc() {
    return pc;
  }

  public int getAcc() {
    return acc;
  }

}
