package clients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Others.DeliveryMan;
import Others.SweetShop;
import cakes.Cake;

public class PrClient extends Client{
	//discount in money [10-30]-> number of discounts [1-4]
	private HashMap<Integer, Integer> discounts;

	public PrClient(String name, String tel, double money) {
		super(name, tel, money);
		this.discounts = new HashMap<>();
		this.discounts.put(new Random().nextInt(21) + 10, new Random().nextInt(4) + 1);
	}
	
	public int getAllDiscount() {
		int discount = 0;
		for(Integer i : discounts.values()) {
			discount += i;
		}
		return discount;
	}

	@Override
	public void makeOrder(SweetShop s) {
		//[1-3] cakes
		int randomCakes = new Random().nextInt(3) + 1;
		ArrayList<Cake> cakes = new ArrayList<>();
		for (int i = 0; i < randomCakes; i++) {
			Cake c = getRandomCake(s);
			cakes.add(c);
		}
		s.makeOrder(cakes, this);
	}

	@Override
	public void giveTip(int price, DeliveryMan dm) {
		dm.takeTip(price * 0.02);
		this.money -= price * 0.02;
	}

}
