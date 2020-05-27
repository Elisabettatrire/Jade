package agents;

import behav.ReceivePrintingRequest;
import behav.RegisterToDF;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Stampatore extends Agent
{
	public static final String SERVICE_NAME = "print";
	public static final String SERVICE_TYPE = "print-service";
	public static final String CONV_ID = "print-conv";
	
	public void setup()
	{
		this.addBehaviour(new ReceivePrintingRequest(this));
		this.addBehaviour(new WakerBehaviour(this, 10000)
		{
			protected void onWake()
			{
				this.myAgent.addBehaviour(new RegisterToDF(this.myAgent, getDescription()));
			}
		});
	}
	
	public static DFAgentDescription getDescription()
	{
		DFAgentDescription dad = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName(SERVICE_NAME);
		sd.setType(SERVICE_TYPE);
		dad.addServices(sd);
				
		return dad;
	}
	
	public void takeDown()
	{
		try {
			DFService.deregister(this);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
