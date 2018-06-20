package simulaPosto;

import eduni.simjava.*;

public class Pagamento extends Sim_entity {
	  private Sim_port entrada, saida;
	  private double delay;

	  Pagamento(String name, double delay) {
		  super(name);
		  this.delay = delay;
		// Porta for receiving form Bombas
		entrada = new Sim_port("EntradaPagamento");
		// Port for sending to Saida
		saida = new Sim_port("SaidaPagamento");
		add_port(entrada);
		add_port(saida);

	  }
	  
	  public void body() {
		  while (Sim_system.running()) {
		      Sim_event e = new Sim_event();
		      sim_get_next(e);
		      sim_process(delay);
		      sim_completed(e);
		      sim_trace(1, "Disk1 selected for I/O work.");
		      sim_schedule(saida, 0.0, 1);
		  }
	  }
}
