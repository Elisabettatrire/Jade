package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class InteractionBehaviour extends OneShotBehaviour
{
	private AID otherAid;

	public InteractionBehaviour(Agent a, AID otherAid)
	{
		super(a);
		this.otherAid = otherAid;
	}
	
	public void action()
	{
	}

	public AID getOtherAid() {
		return otherAid;
	}

	public void setOtherAid(AID otherAid) {
		this.otherAid = otherAid;
	}

}
