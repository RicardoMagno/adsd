package simulaPosto;

import eduni.simjava.*;
import eduni.simjava.distributions.*;


public class BombaGasolina extends Sim_entity {

	private Sim_port entrada, saida;
	private Sim_normal_obj delay;
    private Sim_random_obj prob;
    Sim_stat stat;
    
	BombaGasolina(String name, double mean, double var) {
		super(name);
		
		// Port for receiving form Cliente
		entrada = new Sim_port("EntradaBomba");
		// Port for sending to Pagamento
		saida = new Sim_port("SaidaBomba");
		add_port(entrada);
		add_port(saida);
		
		// Cria a distribuição e o gerador do processador e adiciona-os
		delay = new Sim_normal_obj("Delay", mean, var);
        prob = new Sim_random_obj("Probability");
        add_generator(delay);
        add_generator(prob);

        stat = new Sim_stat();
        stat.add_measure(Sim_stat.THROUGHPUT);
        stat.add_measure(Sim_stat.RESIDENCE_TIME);
        stat.set_efficient(Sim_stat.THROUGHPUT);
        stat.set_efficient(Sim_stat.RESIDENCE_TIME);
        set_stat(stat);
	}

	
	public void body() {
        while (Sim_system.running()) {
          Sim_event e = new Sim_event();
          sim_get_next(e);
          // Sample the distribution
          sim_process(delay.sample());
          sim_completed(e);
          // Get the next probability
          double p = prob.sample();
          
       // carro vai para pagamento
	      sim_trace(1, "Veiculo enviado ao Pagamento");
          sim_schedule(saida, 0.0, 1);
        }
      }
}
