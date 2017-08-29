package clients;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.text.BadLocationException;
import javax.swing.text.Position.Bias;

import others.View;
import agency.Agency;
import agency.Agent;
import properties.Property;

public class Buyer extends Client {
	private ArrayList<View> views;
	private Agent agent;

	public Buyer(String name, String tel, int money) {
		super(name, tel, money);
		this.views = new ArrayList<>();
	}
	
	public void requestSearch(Property p, Agency a) {
		a.addBuyerAgent(this);
	}
	
	public void requestView(Property p, Agency a) {
		if(p.getPrice() + 0.03 * p.getPrice() < this.money) {
			if(this.agent != null) {
				this.views.add(new View(p, this.agent, this));
				this.agent.addPropertyViewed(p);
			}else {
				System.out.println("The buyer has not registered a Search Request");
			}
		}else {
			System.out.println("Buyer doesn't have enough money to see the property");
		}
	}
	
	public void requestBuy(Property p, Agency a) {
		if(isPropertyViewed(p)) {
			p.getSeller().takeMoneyFromSelling(p.getPrice());
			
			this.money -= p.getPrice() -  0.03 * p.getPrice();
			a.takeMoneyAndGiveToAgent((int) (0.03 * p.getPrice()), this.agent);
			
			p.getSeller().givePercentToAgency(p, a, this.agent);
			
		}
	}

	private boolean isPropertyViewed(Property p) {
		for(View v : this.views) {
			if(v.getProp().equals(p)) { 
				return true;
			}
		}
		return false;
	}

	public void addAgent(Agent a) {
		this.agent = a;
	}
	
	public Collection<View> getViews() {
		return Collections.unmodifiableCollection(this.views);
	}
	
}
