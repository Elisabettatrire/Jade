package agents;

import behav.ReceiveMessage;
import behav.SearchService;
import jade.core.Agent;

public class Richiedente extends Agent
{
	public void setup()
	{
		this.addBehaviour(new ReceiveMessage(this));
		this.addBehaviour(new SearchService(this, 1500, Stampatore.getDescription()));
	}
}
