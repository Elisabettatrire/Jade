package behav;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.WakerBehaviour;
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
		System.out.println(this.myAgent.getLocalName() + ": controllo messaggi");
		
		//ACLMessage msg = this.myAgent.receive();
		//ACLMessage msg = this.myAgent.blockingReceive();
		
		//ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		ACLMessage msg = this.myAgent.receive(MessageTemplate.or(
					MessageTemplate.MatchPerformative(ACLMessage.AGREE),
					MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
										MessageTemplate.MatchConversationId("idconversazione"))
				));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() + ": ho ricevuto un messaggio da " +
						msg.getSender().getLocalName()
					);
			System.out.println(this.myAgent.getLocalName() + ": il contenuto del messaggio e' " + 
						msg.getContent()
					);
			
			ACLMessage reply = msg.createReply();
			reply.setContent("risposta a: " + msg.getSender().getLocalName());
			reply.setPerformative(ACLMessage.AGREE);
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 2000) {
				protected void onWake()
				{
					this.myAgent.send(reply);
				}
			});
		}
		else
		{
			this.block();
		}
	}
}
