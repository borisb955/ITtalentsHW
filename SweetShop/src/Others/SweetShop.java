package Others;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

import cakes.Cake;
import cakes.Cake.CakeKind;
import clients.Client;
import clients.CorClient;
import clients.PrClient;

public class SweetShop {
	private String name;
	private String address;
	private String tel;
	private double money;
	private HashSet<DeliveryMan> deliveryMen;
	private HashMap<CakeKind, HashMap<String, TreeSet<Cake>>> cakes;
	private HashMap<CakeKind, HashMap<String, TreeSet<Cake>>> cakesSold;
	private HashSet<Cake> allCakes;
	
	public SweetShop(String name, String address, String tel, HashSet<DeliveryMan> deliveryMen) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.deliveryMen = deliveryMen;
		this.cakes = new HashMap<>();
		this.allCakes = new HashSet<>();
		this.cakesSold = new HashMap<>();
	}
	
	public void addCake(Cake c) {
		addCake(cakes, c);
		this.allCakes.add(c);
	}
	
	public Collection<Cake> getAllCakes() {
		return Collections.unmodifiableCollection(allCakes);
	}
	
	public Map<CakeKind, HashMap<String, TreeSet<Cake>>> getCakesSold() {
		return Collections.unmodifiableMap(this.cakesSold);
	}
	
	
	public void makeOrder(ArrayList<Cake> cakes, Client client) {
		//calculating the order's price with discounts
		int price = 0;
		for (int i = 0; i < cakes.size(); i++) {
			price += cakes.get(i).getPrice();
		}
		if(client instanceof CorClient) {
			price -= ((CorClient) client).getDiscount() * price;
		}
		if(client instanceof PrClient) {
			price -= ((PrClient) client).getAllDiscount();
			if(price < 0) {
				price = 0;
			}
		}
		
		Order order = new Order(client, price, "Nqkvo adressche " + new Random().nextInt(300)+1, cakes, getRandomDm());
		order.getDeliveryMan().deliver(order, this);
		
		//Adding cakes to soldCakes's Map
		for (Cake c : cakes) {
			addCake(this.cakesSold, c);
		}
		//Removing from this ArrayList in order Clients to choose from cakes that have not been chosen
		allCakes.removeAll(cakes);
		//Removing from this.cakes
		for (Cake cake : cakes) {
		this.cakes.get(cake.getKind()).get(cake.getType()).remove(cake);
		}
		//Setting Client's paidPrice
		client.setMoneyGivenForCakes(price);
	}
	
	private DeliveryMan getRandomDm() {
		int random = new Random().nextInt(this.deliveryMen.size());
		int num = 0;
		
		for(DeliveryMan dm : deliveryMen) {
			if(random == num++) {
				return dm;
			}
		}
		return null;
	}

	public void increaseMoney(int price) {
		this.money += price;
	}
	
	public void showCakesInfo() {
		for(CakeKind ck : this.cakes.keySet()) {
			System.out.println();
			System.out.println("=============");
			System.out.println(ck);
			System.out.println("=============");
			for(String hm : this.cakes.get(ck).keySet()) {
				System.out.print(hm + " - " + this.cakes.get(ck).get(hm).size() + " / " );
			}
		}
	}
	
	public double getMoney() {
		return money;
	}
	
	public Collection<DeliveryMan> getDeliveryMen() {
		return Collections.unmodifiableCollection(deliveryMen);
	}
	
	public void addCake(HashMap<CakeKind, HashMap<String, TreeSet<Cake>>> cakes, Cake c) {
		if(!cakes.containsKey(c.getKind())) {
			cakes.put(c.getKind(), new HashMap<>());
			if(!cakes.get(c.getKind()).containsKey(c.getType())) {
				cakes.get(c.getKind()).put(c.getType(), new TreeSet<>());
			}
		}else {
			if(!cakes.get(c.getKind()).containsKey(c.getType())) {
				cakes.get(c.getKind()).put(c.getType(), new TreeSet<>());
			}
		}
		cakes.get(c.getKind()).get(c.getType()).add(c);
	}
}
