package utils;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class PlatformCreator {

	public static void main(String[] args)
	{
		Runtime rt = Runtime.instance();
		ProfileImpl p = new ProfileImpl();
		p.setParameter("gui", "true");
		
		ContainerController cc = rt.createMainContainer(p);
		try {
			AgentController ac = cc.createNewAgent("Gilbert", "agents.MyAgent", null);
			ac.start();
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
