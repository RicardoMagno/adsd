package simulaPosto;

import eduni.simjava.*;

public class Main {
	public static void main(String[] args) {
		Sim_system.initialise();
		Cliente cliente = new Cliente("Cliente", 20);
		BombaGasolina bomba1 = new BombaGasolina("Bomba1", 25, 10);
		BombaAlcoolGasolina bomba2 = new BombaAlcoolGasolina("Bomba2", 40, 10);
		BombaAlcoolGasolinaDiesel bomba3 = new BombaAlcoolGasolinaDiesel("Bomba3", 100, 10);
		Pagamento pagamento = new Pagamento("Pagamento",60, 10);
		Saida saida = new Saida("Saida", 30, 10);
		
		//As portas da simulação serão ligadas usando sim_system
		Sim_system.link_ports("Cliente", "Bomba1 com gasolina", "Bomba1", "EntradaBomba");
		Sim_system.link_ports("Cliente", "Bomba2 com gasolina e alcool", "Bomba2", "EntradaBomba");
		Sim_system.link_ports("Cliente", "Bomba2 com diesel tambem", "Bomba3", "EntradaBomba");
		Sim_system.link_ports("Bomba1", "SaidaBomba", "Pagamento", "EntradaPagamento");
		Sim_system.link_ports("Bomba2", "SaidaBomba", "Pagamento", "EntradaPagamento");
		Sim_system.link_ports("Bomba3", "SaidaBomba", "Pagamento", "EntradaPagamento");
		Sim_system.link_ports("Pagamento", "SaidaPagamento", "Saida", "In");

		//Para definir os detalhes do arquivo de rastreio, o método set_trace_detail () é usado 
	    Sim_system.set_trace_detail(true, true, true);
	    Sim_system.run();
	}
}
