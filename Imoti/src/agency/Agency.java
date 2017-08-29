package agency;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

import clients.Buyer;
import clients.Seller;
import properties.Apartment;
import properties.Property;

public class Agency {
	private String name;
	private String address;
	private String tel;
	private int money;
	private HashSet<Agent> agents;
	private HashMap<Integer, HashSet<Property>> properties;
	
	public Agency(String name, String address, String tel, HashSet<Agent> agents) {
		super();
		this.agents = agents;
		this.properties = new HashMap<Integer, HashSet<Property>>();
		this.name = name;
		this.address = address;
		this.tel = tel;
	}

	public void registerProperty(Property p, Seller s) {
		Agent a = getRandomAgent();
		s.addAgent(a);
		a.addProperty(p);
		p.addSeller(s);
		//adding property to the HashMap
		if(properties.containsKey(p.getUniqueType())) {
			this.properties.get(p.getUniqueType()).add(p);
		}else {
			this.properties.put(p.getUniqueType(), new HashSet<Property>());
			this.properties.get(p.getUniqueType()).add(p);
		}

		
	}
	
	private Agent getRandomAgent() {
		int random = new Random().nextInt(agents.size());
		int num = 0;
		
		for (Agent agent : agents) {
			if(random == num++) {
				return agent;
			}
		}
		return null;
	}

	public void addBuyerAgent(Buyer b) {
		Agent agent = getRandomAgent();
		b.addAgent(agent);
		agent.addBuyer(b);
		
	}

	public void takeMoneyAndGiveToAgent(int money, Agent agent) {
		int moneyEach = (int) (0.5 * money);
		this.money += moneyEach;
		agent.takeMoney(moneyEach);
		
	}
	
	public Map<Integer, HashSet<Property>> getProperties() {
		return Collections.unmodifiableMap(properties);
	}
	
	public int getMoney() {
		return money;
	}
	
	public Collection<Agent> getAgents() {
		return Collections.unmodifiableCollection(agents);
	}
}
