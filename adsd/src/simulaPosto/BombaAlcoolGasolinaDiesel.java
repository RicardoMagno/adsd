package simulaPosto;

import eduni.simjava.*;

public class BombaAlcoolGasolinaDiesel extends Sim_entity {

	private Sim_port entrada, saida;
	private double delay;
	
	public BombaAlcoolGasolinaDiesel(String name, double delay) {
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
		//TODO: selecionar eventos
	}
}