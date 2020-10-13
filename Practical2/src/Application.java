import examples.bookTrading.BookBuyerAgent;
import examples.bookTrading.BookSellerAgent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

import examples.behaviours.ComplexBehaviourAgent;

public class Application {



	public static void main(String[] args){
		//Setup the JADE environment
		Profile myProfile = new ProfileImpl();
		Runtime myRuntime = Runtime.instance();
		ContainerController myContainer = myRuntime.createMainContainer(myProfile);





		try{
			//Start the agent controller, which is itself an agent (rma)
			AgentController rma = myContainer.createNewAgent("rma", "jade.tools.rma.rma",
					null);
			rma.start();


			//Now start our own BookBuyerAgent, called buyer.

			AgentController myAgentSeller = myContainer.createNewAgent("sellerA",
					BookSellerAgent.class.getCanonicalName(), null);
			myAgentSeller.start();
			//Seller2
			AgentController myAgentSeller2 = myContainer.createNewAgent("sellerB",
					BookSellerAgent.class.getCanonicalName(), null);
			myAgentSeller2.start();
			//Seller3
			AgentController myAgentSeller3 = myContainer.createNewAgent("sellerC",
					BookSellerAgent.class.getCanonicalName(), null);
			myAgentSeller3.start();

			//Seller4

			AgentController myAgentSeller4 = myContainer.createNewAgent("sellerD",
					BookSellerAgent.class.getCanonicalName(), null);
			myAgentSeller4.start();
			//Seller5

			AgentController myAgentSeller5 = myContainer.createNewAgent("sellerE",
					BookSellerAgent.class.getCanonicalName(), null);
			myAgentSeller5.start();
			
			
			
			
			
			Thread.yield();
			String[] books = {"Java"};
			AgentController myAgentBuyer = myContainer.createNewAgent("buyer",
					BookBuyerAgent.class.getCanonicalName(), books);
			myAgentBuyer.start();





		}catch(Exception e){
			System.out.println("Exception starting agent: " + e.toString());
		}
	}
}

