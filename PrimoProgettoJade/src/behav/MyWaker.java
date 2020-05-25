package behav;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class MyWaker extends WakerBehaviour
{
	private long currentTime;
	public MyWaker(Agent a, long timeout)
	{
		super(a, timeout);
		currentTime = System.currentTimeMillis();
	}
	
	protected void onWake()
	{
		long timeStamp = System.currentTimeMillis();
		long timePast = timeStamp - currentTime;
		System.out.println(this.myAgent.getLocalName() + ": my waker --- " + timePast);
	}
}
