package behav;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MyOneShot extends OneShotBehaviour
{
	public MyOneShot(Agent a)
	{
		super(a);
	}
	
	public void action()
	{
		System.out.println(this.myAgent.getName() + ": my one shot behaviour");
	}
}
