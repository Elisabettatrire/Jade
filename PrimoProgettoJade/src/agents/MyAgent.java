package agents;

import jade.core.Agent;

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
	}
}
