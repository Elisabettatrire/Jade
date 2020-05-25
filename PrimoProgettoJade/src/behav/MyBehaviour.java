package behav;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MyBehaviour extends Behaviour
{
	private int counter;
	
	public MyBehaviour(Agent a)
	{
		super(a);
		counter = 0;
	}
	
	public void action()
	{
		System.out.println(this.myAgent.getLocalName() + ": " + counter);
		counter++;
	}
	
	public boolean done()
	{
		if (counter < 3)
		{
			return false;
		}
		
		return true;
	}
}
