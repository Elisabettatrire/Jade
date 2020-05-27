package behav;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class RegisterToDF extends OneShotBehaviour
{
	private DFAgentDescription dad;
	
	public RegisterToDF(Agent a, DFAgentDescription dad)
	{
		super(a);
		this.dad = dad;
	}
	
	public void action()
	{
		try
		{
			DFService.register(this.myAgent, dad);
		}
		catch (FIPAException e)
		{
			e.printStackTrace();
			//this.myAgent.addBehaviour(new RegisterToDF(this.myAgent, dad));
		}
	}

}
