package agents;

import behav.MyBehaviour;
import behav.MyCyclic;
import behav.MyOneShot;
import behav.MyTicker;
import behav.MyWaker;
import behav.ReceiveMessage;
import behav.SendMessage;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class MyAgent extends Agent
{
	public void setup()
	{
		/*
		 * Agent Identifier AID
		 * AID è composto da GUID + indirizzi
		 * GUID è composto da local name @ nome della piattaforma ad agenti
		 */
		System.out.println(this.getLocalName() + ": Inizializzazione...");
		
		String[] addresses = this.getAID().getAddressesArray();
		
		if (addresses != null)
		{
			System.out.println(this.getLocalName() + ": i miei indirizzi sono");
			for (String address : addresses)
			{
				System.out.println(address);
			}
		}
		
		//this.addBehaviour(new MyBehaviour(this));
		//this.addBehaviour(new MyOneShot(this));
		//this.addBehaviour(new MyCyclic(this));
		//this.addBehaviour(new MyWaker(this, 1500));
		//this.addBehaviour(new MyTicker(this, 1500));
		/*
		this.addBehaviour(new WakerBehaviour(this, 2000) {
			protected void onWake()
			{
				System.out.println(this.myAgent.getLocalName() + ": sto per aggiungere il ticker...");
				this.myAgent.addBehaviour(new MyTicker(this.myAgent, 500));
			}
		});
		*/
		
		this.addBehaviour(new ReceiveMessage(this));
		
		Object[] args = this.getArguments();
		
		if (args != null && args.length > 0 && args[0].toString().equals("send"))
		{
			this.addBehaviour(new WakerBehaviour(this, 5000)
			{
				protected void onWake()
				{
					this.myAgent.addBehaviour(new SendMessage(this.myAgent));
				}
			});
		}
		/*
		else
		{
			this.addBehaviour(new MyTicker(this, 1500));
			this.addBehaviour(new ReceiveMessage(this));
		}
		*/
	}
}
