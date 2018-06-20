package simulaPosto;

import eduni.simjava.*;

public class Cliente extends Sim_entity{
	private Sim_port saida1, saida2, saida3;
	private double delay;
	
	Cliente(String name, double delay) {
		super(name);
	    this.delay = delay;
	    // Port for sending events to disk 1
	    saida1 = new Sim_port("Bomba1 com gasolina");
	    // Port for sending events to disk 2
	    saida2 = new Sim_port("Bomba2 com gasolina e alcool");
	    // Port for sending events to disk 2
	    saida3 = new Sim_port("Bomba2 com diesel tambem");
	    add_port(saida1);
	    add_port(saida2);
	    add_port(saida3);
	}

	public  void body() {
		int i = 0;
	    while (Sim_system.running()) {
	      Sim_event e = new Sim_event();
	      sim_get_next(e);
	      sim_process(delay);
	      sim_completed(e);
	      if ((i % 3) == 0) {
	    	sim_trace(1, "Bomba 1 escolhida para abastecimento");
	    	sim_schedule(saida1, 0.0, 1);
	      } else if ((i % 2) == 0) {
	    	sim_trace(1, "Bomba 2 escolhida para abastecimento");
	    	sim_schedule(saida2, 0.0, 1);
	      } else {
	    	sim_trace(1, "Bomba 3 escolhida para abastecimento");
	    	sim_schedule(saida3, 0.0, 1);
	      }
	      i++;
	    }
	  }
}
