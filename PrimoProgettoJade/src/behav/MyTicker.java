package behav;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class MyTicker extends TickerBehaviour
{
	private long currentTime;
	
	public MyTicker(Agent a, long period)
	{
		super(a, period);
		currentTime = System.currentTimeMillis();
	}
	
	protected void onTick()
	{
		long timeStamp = System.currentTimeMillis();
		long pastTime = timeStamp - currentTime;
		System.out.println(myAgent.getLocalName() + ": my ticker --- " + pastTime);
		currentTime = timeStamp;
		//this.myAgent.addBehaviour(new MyOneShot(this.myAgent));
	}
}
