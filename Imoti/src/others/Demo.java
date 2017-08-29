package others;

import java.awt.PageAttributes;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import agency.Agency;
import agency.Agent;
import clients.Buyer;
import clients.Seller;
import properties.Apartment;
import properties.House;
import properties.Parcel;
import properties.Property;

public class Demo {
	public static void main(String[] args) {
		HashSet<Agent> agents = new HashSet<>();
		HashSet<Seller> sellers = new HashSet<>();
		HashSet<Buyer> buyers = new HashSet<>();
 		for (int i = 0; i < 5; i++) {
			agents.add(new Agent("Agent " + (i+1), "08855" + i));
		}
		
		Agency talanti = new Agency("Talanti", "Akademik Svishtov 33", "08448484", agents);
		
		for (int i = 0; i < 30; i++) {
			int random = new Random().nextInt(3);
			Property p = new Apartment("Very good appartment", "Bul Bulgaria", new Random().nextInt(80000) + 70000); // for initialization
			switch(random) {
				case 1: p = new House("Very good House", "Bul Tsar Boris 3", new Random().nextInt(30000) + 50000, new Random().nextInt(5), new Random().nextInt(100) );
						break;
				case 2: p = new Parcel("Very good Parcel", "Bul Stamboliiski", new Random().nextInt(55000) + 30000, new Random().nextBoolean());
						break;
				default:break;
			}
			
			
			sellers.add(new Seller("Seller " + i, "088" + i, 100, p));
		}
		
		//3. All sellers register their property for selling -> Agency
		for (Seller s : sellers) {
			s.registerProperty(talanti);
		}
		
		// 4. Making 10 buyers with random money[40 000 - 200 000]
		for (int i = 0; i < 10; i++) {
			buyers.add(new Buyer("Buyer " + i, "035" + i, new Random().nextInt(200000) + 40000));
		}
		
		//5. All buyers request Search 
		for (Buyer b : buyers) {
			b.requestSearch(getRandomProperty(talanti), talanti);
		}
		
		//6. All buyers make 3 random views
		for (Buyer b : buyers) {
			for (int i = 0; i < 3; i++) {
				b.requestView(getRandomProperty(talanti), talanti);
			}
		}
		
		//7. All buyers purchase one of the properties that they have viewed
		for (Buyer b : buyers) {
			//Taking unmodified collection (views)
			Collection<View> views = b.getViews();
			//Some buyers have not make any views because of lack of money
			if(views.size() != 0) {
				//Get Random View and from it take the property
				int random = new Random().nextInt(views.size());
				int num = 0;
				View view = null;
				for(View v : views) {
					if(random == num++) {
						view = v;
					}
				}
				b.requestBuy(view.getProp(), talanti);
			}
			
		}
		
		//8. Show Agency's money
		System.out.println("\nMoney of Talanti : " + talanti.getMoney());
		
		//9. Sort Agents by money
		//get unmodifiable collection
		Collection<Agent> talantiAgents = talanti.getAgents();
		//sorted by "money" then "name"
		TreeSet<Agent> sortedAgents = new TreeSet<>((a1, a2) ->{
			if(a1.getMoney() == a2.getMoney()) {
				return a1.getName().compareTo(a2.getName());
			}
			return a2.getMoney() - a1.getMoney();
			});
		//Adding to sorted collection
		for(Agent a : talantiAgents) {
			sortedAgents.add(a);
		}
		System.out.println(sortedAgents);
		
		
		//Testing if the properties in the Agency are sorted (1 is Apartment 2 is House 3 is Parcel)
		Map<Integer, HashSet<Property>> p = talanti.getProperties();
		System.out.println("\n" + p);
	}
	
	private static Property getRandomProperty(Agency talanti) {
		Map<Integer, HashSet<Property>> p = talanti.getProperties();
		int randomKey = new Random().nextInt(p.size()) + 1;
		int randomProp = new Random().nextInt(p.get(randomKey).size());
		int num = 0;
		Property prop = null;
		for (Property property : p.get(randomKey)) {
			if(randomProp == num++) {
				prop = property;
			}
		}
		return prop;
	}
}
