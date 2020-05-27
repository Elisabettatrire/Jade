package behav;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class SearchService extends TickerBehaviour
{
	private DFAgentDescription dadToSearch;
	
	public SearchService(Agent a, long period, DFAgentDescription toSearch)
	{
		super(a, period);
		this.dadToSearch = toSearch;
	}
	
	
	protected void onTick()
	{
		try {
			DFAgentDescription[] dads = DFService.search(this.myAgent, dadToSearch);
			
			if (dads != null && dads.length > 0)
			{
				for (DFAgentDescription dad : dads)
				{
					this.myAgent.addBehaviour(new RequestPrintService(myAgent, dad.getName()));
				}
				
				this.stop();
			}
			else
			{
				System.out.println(this.myAgent.getLocalName() + ": nessun servizio trovato");
			}
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
