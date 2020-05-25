package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessage extends OneShotBehaviour
{
	public SendMessage(Agent a)
	{
		super(a);
	}
	
	public void action()
	{
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		AID receiver = new AID();
		receiver.setLocalName("Gilbert");
		msg.setContent("messaggio");
		msg.addReceiver(receiver);
		msg.setConversationId("idconversazione");
		
		this.myAgent.send(msg);
		
	}
}
