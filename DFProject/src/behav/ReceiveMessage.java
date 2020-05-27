package behav;

import agents.Stampatore;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveMessage extends CyclicBehaviour
{
	public ReceiveMessage(Agent a)
	{
		super(a);
	}

	public void action()
	{
		ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchConversationId(Stampatore.CONV_ID));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() + ": ho ricevuto un msg da " + 
					msg.getSender().getLocalName()
				);
			System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
			System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
		}
		else
		{
			this.block();
		}
	}

}
