package behav;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceivePrintingRequest extends CyclicBehaviour
{
	public ReceivePrintingRequest(Agent a)
	{
		super(a);
	}
	
	public void action()
	{
		ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() + ": ho ricevuto una richiesta da " +
						msg.getSender().getLocalName()
					);
		
			ACLMessage reply = msg.createReply();
			reply.setPerformative(ACLMessage.AGREE);
			reply.setContent("Accetto la tua richiesta");
			
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 2000)
			{
				protected void onWake()
				{
					this.myAgent.send(reply);
					
					System.out.println(this.myAgent.getLocalName() + ": il messaggio che devo stampare e'");
					System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
					
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Ho stampato il tuo messaggio");
					
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
