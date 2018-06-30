package simulaPosto;

import eduni.simjava.*; 
import eduni.simjava.distributions.*;

public class Cliente extends Sim_entity{
	
	// Portas são os meios pelos quais as entidades se comunicam entre si agendando eventos 
	private Sim_port saida1, saida2, saida3;
	private Sim_negexp_obj delay;
	
	//Eh no construtor que sao definidas as portas 
	Cliente(String name, double mean) {
		super(name);
	
	    // Port for sending events to disk 1
	    saida1 = new Sim_port("Bomba1 com gasolina");
	    // Port for sending events to disk 2
	    saida2 = new Sim_port("Bomba2 com gasolina e alcool");
	    // Port for sending events to disk 2
	    saida3 = new Sim_port("Bomba2 com diesel tambem");
	    
	    //adiciona a porta a entidade
	    add_port(saida1);
	    add_port(saida2);
	    add_port(saida3);
	    
	    delay = new Sim_negexp_obj("Delay", mean);
        add_generator(delay);
	}

	//comportamento da entidade
	public  void body() {
		for (int i=0; i < 100; i++) {
			
		  /**Quando um evento é recebido por seu destinatário, ele é recebido como um objeto Sim_event	
	      Sim_event e = new Sim_event();
	      sim_get_next(e);
	
	      //Este método define uma entidade para ser processada por algum período de tempo
	      //sim_process(delay);
	      
	      //é usado para sinalizar quando um evento é considerado como tendo concluído todo
	      //o serviço em uma entidade
	      sim_completed(e);
	      **/
			
			
	      
	      /** O rastreamento de entidade é produzido pelo modelador, modificando 
	       * as entidades para produzir saída de rastreio. Isso é obtido por 
	       * meio do método sim_trace ()
	       **/
	      
	      if ((i % 3) == 0) {
	    	  
	    	//métodos de planejamento de eventos sim_schedule ()  
	    	sim_schedule(saida1, 0.0, 1);
	    	// todo o traço produzido é impresso em um arquivo (sim_trace)
	    	sim_trace(1, "Bomba 1 escolhida para abastecimento");
	    	
	      } else if ((i % 2) == 0) {
	    	sim_schedule(saida2, 0.0, 1);
	    	sim_trace(1, "Bomba 2 escolhida para abastecimento");

	      } else {
	    	sim_schedule(saida3, 0.0, 1);
	    	sim_trace(1, "Bomba 3 escolhida para abastecimento"); 
	      } 
	      sim_pause(delay.sample());
	     }  
	  } 
}

