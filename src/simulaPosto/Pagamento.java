package simulaPosto;

import eduni.simjava.*;
import eduni.simjava.distributions.Sim_normal_obj;

public class Pagamento extends Sim_entity {
	  private Sim_port entrada, saida;
	  private Sim_normal_obj delay;
	  Sim_stat stat;
	

	  Pagamento(String name, double mean, double var) {
		  super(name);
		 
		// Porta for receiving form Bombas
		entrada = new Sim_port("EntradaPagamento");
		// Port for sending to Saida
		saida = new Sim_port("SaidaPagamento");
		add_port(entrada);
		add_port(saida);

		//Cria a distribuição em cliente (?) e adiciona-o
		delay = new Sim_normal_obj("Delay", mean, var);
        add_generator(delay);
        
        stat = new Sim_stat();
        stat.add_measure(Sim_stat.UTILISATION);
        set_stat(stat);
	  }
	  
	  
	  public void body() {
          while (Sim_system.running()) {
            Sim_event e = new Sim_event();
            sim_get_next(e);
            // Sample the distribution
            sim_process(delay.sample());
            sim_completed(e);
            
            sim_trace(1, "Disk1 selected for I/O work.");
		    sim_schedule(saida, 0.0, 1);
          }
        }
}
