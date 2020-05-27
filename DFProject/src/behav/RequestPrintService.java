package behav;

import agents.Stampatore;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class RequestPrintService extends InteractionBehaviour
{
	public RequestPrintService(Agent a, AID printer)
	{
		super(a, printer);
	}
	
	public void action()
	{
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.setContent("qualcosa da stampare");
		msg.addReceiver(this.getOtherAid());
		msg.setConversationId(Stampatore.CONV_ID);
		
		this.myAgent.send(msg);
	}
}
