package simulaPosto;

import eduni.simjava.*;

class Saida extends Sim_entity {
	private Sim_port entrada;
	private double delay;
	Saida(String name, double delay){
		super(name);
		this.delay = delay;
		entrada = new Sim_port("EntradaSaida");
	    add_port(entrada);
	}
	
	  public void body() {
		    while (Sim_system.running()) {
		      Sim_event e = new Sim_event();
		      sim_get_next(e);
		      sim_trace(1, "Cliente terminou" );
		      sim_process(delay);
		      sim_completed(e);
		    }
		  }
}
