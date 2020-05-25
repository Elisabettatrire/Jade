package behav;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class MyCyclic extends CyclicBehaviour
{
	public MyCyclic(Agent a)
	{
		super(a);
	}
	
	public void action()
	{
		System.out.println(this.myAgent.getLocalName() + ": my cyclic behaviour");
	}
}
