package agency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import others.View;
import clients.*;
import properties.Property;

public class Agent {
	private String name;
	private String tel;
	private int money;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private HashSet<View> views;
	private TreeSet<Property> properties;
	private ArrayList<Property> propertiesViewed;
	
	public Agent(String name, String tel) {
		super();
		this.sellers = new HashSet<>();
		this.buyers = new HashSet<>();
		this.views = new HashSet<>();
		this.properties = new TreeSet<>();
		this.propertiesViewed = new ArrayList<>();
		this.name = name;
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	public void addProperty(Property p) {
		this.properties.add(p);
		
	}

	public void addPropertyViewed(Property p) {
		this.propertiesViewed.add(p);
		
	}

	public void takeMoney(int moneyEach) {
		this.money += moneyEach;
		
	}

	public void addBuyer(Buyer b) {
		this.buyers.add(b);
	}
	
	public int getMoney() {
		return money;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.money;
	}
	
	public String getName() {
		return name;
	}
	
}
