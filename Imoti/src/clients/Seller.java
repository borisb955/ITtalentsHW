package clients;

import agency.Agency;
import agency.Agent;
import properties.Property;

public class Seller extends Client {
	private Property prop;
	private Agent agent;

	public Seller(String name, String tel, int money, Property prop) {
		super(name, tel, money);
		this.prop = prop;
	}
	
	public void registerProperty(Agency a) {
		a.registerProperty(this.prop, this);
	}
	
	public void addAgent(Agent a) {
		if(this.agent == null) {
			this.agent = a;
		}else {
			System.out.println("This seller already has an agent.");
		}
	}

	public void takeMoneyFromSelling(int price) {
		this.money += price;
		
	}

	public void givePercentToAgency(Property p, Agency agency, Agent agent) {
		int moneyGiven = (int) (p.getPrice() * 0.03);
		this.money -= moneyGiven;
		agency.takeMoneyAndGiveToAgent(moneyGiven, agent);
		
	}

}
