package behav;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.SubscriptionInitiator;

public class SubscribeToPrint extends SubscriptionInitiator 
{
	public SubscribeToPrint(Agent a, ACLMessage msg)
	{
		super(a, msg);
	}
	
	public void handleInform(ACLMessage inform)
	{
		try
		{
			DFAgentDescription[] dads = DFService.decodeNotification(inform.getContent());
			
			if (dads != null && dads.length > 0)
			{
				System.out.println(this.myAgent.getLocalName() + ": ci sono " + dads.length + " agenti che "
							+ "offrono il servizio di stampa"
						);
				for (DFAgentDescription dad : dads)
				{
					this.myAgent.addBehaviour(new RequestPrintService(this.myAgent, dad.getName()));
				}
			}
		}
		catch (FIPAException e) 
		{
			e.printStackTrace();
		}
	}
}
