package clients;

import java.util.ArrayList;
import java.util.Random;

import Others.DeliveryMan;
import Others.Order;
import Others.SweetShop;
import cakes.Cake;

public class CorClient extends Client{
	private double discount;

	public CorClient(String name, String tel, double money) {
		super(name, tel, money);
		this.discount = (new Random().nextInt(6) + 10) / 100.0;
	}

	public void makeOrder(SweetShop s) {
		//[3-5] cakes
		int randomCakes = new Random().nextInt(3) + 3;
		ArrayList<Cake> cakes = new ArrayList<>();
		for (int i = 0; i < randomCakes; i++) {
			Cake c = getRandomCake(s);
			cakes.add(c);
		}
		s.makeOrder(cakes, this);	
	}
	
	@Override
	public void giveTip(int price, DeliveryMan dm) {
		dm.takeTip(price * 0.05);
		this.money -= price * 0.05;
	}
	

	
	public double getDiscount() {
		return discount;
	}
}
