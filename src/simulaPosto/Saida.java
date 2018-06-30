package simulaPosto;

import eduni.simjava.*;
import eduni.simjava.distributions.Sim_normal_obj;

class Saida extends Sim_entity {
	private Sim_port entrada;
	private Sim_normal_obj delay;
	
	Saida(String name, double mean, double var){
		super(name);
		entrada = new Sim_port("In");
	    add_port(entrada);
	    
	  //Cria a distribuição em cliente (?) e adiciona-o
	  	delay = new Sim_normal_obj("Delay", mean, var);
        add_generator(delay);
	}
	
	  public void body() {
		    while (Sim_system.running()) {
		      Sim_event e = new Sim_event();
		      sim_get_next(e);
		      sim_trace(1, "Cliente terminou" );
		      sim_process(delay.sample());
		      sim_completed(e);
		    }
		  }
}
