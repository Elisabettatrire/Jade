package agents;

import behav.ReceiveMessage;
import behav.SearchService;
import behav.SubscribeToPrint;
import jade.core.Agent;
import jade.domain.DFService;
import jade.lang.acl.ACLMessage;

public class Richiedente extends Agent
{
	public void setup()
	{
		this.addBehaviour(new ReceiveMessage(this));
		//this.addBehaviour(new SearchService(this, 1500, Stampatore.getDescription()));
		ACLMessage sub = DFService.createSubscriptionMessage(
					this,
					getDefaultDF(),
					Stampatore.getDescription(), 
					null
				);
		
		this.addBehaviour(new SubscribeToPrint(this, sub));
	}
}
