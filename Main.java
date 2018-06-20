package simulaPosto;

import eduni.simjava.*;

public class Main {
	public static void main(String[] args) {
		Sim_system.initialise();
		Cliente cliente = new Cliente("Cliente", 20);
		BombaGasolina bomba1 = new BombaGasolina("Bomba1",25);
		BombaAlcoolGasolina bomba2 = new BombaAlcoolGasolina("Bomba2", 40);
		BombaAlcoolGasolinaDiesel bomba3 = new BombaAlcoolGasolinaDiesel("Bomba3", 100);
		Pagamento pagamento = new Pagamento("Pagamento",60);
		Saida saida = new Saida("Saida", 30);
		Sim_system.link_ports("Cliente", "Bomba1 com gasolina", "BombaGasolina", "EntradaBomba");
		Sim_system.link_ports("Cliente", "Bomba2 com gasolina e alcool", "BombaAlcoolGasolina", "EntradaBomba");
		Sim_system.link_ports("Cliente", "Bomba2 com diesel tambem", "BombaAlcoolGasolinaDiesel", "EntradaBomba");
		
		Sim_system.link_ports("BombaGasolina", "SaidaBomba", "Pagamento", "EntradaPagamento");
		
		Sim_system.link_ports("BombaAlcoolGasolina", "SaidaBomba", "Pagamento", "EntradaPagamento");
		
		Sim_system.link_ports("BombaAlcoolGasolinaDiesel", "SaidaBomba", "Pagamento", "EntradaPagamento");
		
		Sim_system.link_ports("Pagamento", "SaidaPagamento", "Saida", "In");

	    Sim_system.set_trace_detail(false, true, false);
	    Sim_system.run();
	}
}
