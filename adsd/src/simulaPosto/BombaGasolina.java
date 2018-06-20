package simulaPosto;

import eduni.simjava.*;

public class BombaGasolina extends Sim_entity {

	private Sim_port entrada, saida;
	private double delay;
	
	public BombaGasolina(String name, double delay) {
		super(name);
		this.delay = delay;
		// Port for receiving form Cliente
		entrada = new Sim_port("Entrada");
		// Port for sending to Pagamento
		saida = new Sim_port("Saida");
		add_port(entrada);
		add_port(saida);

	}
	public void body() {
	    while (Sim_system.running()) {
	      Sim_event e = new Sim_event();
	      sim_get_next(e);
	      sim_process(delay);
	      sim_completed(e);
	  	  // carro vai para pagamento
	      sim_trace(1, "Veiculo irá pagar");
	      sim_schedule(saida, 0.0, 1);
      }
	}
}
