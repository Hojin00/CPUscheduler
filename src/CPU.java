
public class CPU {
  private Scheduler sm; // prioridade com preempcao ou nao ou round robin

  CPU(Process p, String schedulerType, int q) {
    sm = setScheduler(schedulerType, q);
    sm.setScheduler(sm);
  }

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

  public static Scheduler setScheduler(String type, int q) {

    switch (type) {
      case "Priority":
        return new Priority();
      case "Round-Robin":
        return new Round_Robin(q);
    }
    return null;
  }

}
