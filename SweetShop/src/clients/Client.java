package clients;

import java.util.Random;

import Others.DeliveryMan;
import Others.SweetShop;
import cakes.Cake;

public abstract class Client {
	protected String name;
	protected String tel;
	protected double money;
	protected int moneyGivenForCakes;
	
	//Constructor
	public Client(String name, String tel, double money) {
		super();
		this.name = name;
		this.tel = tel;
		this.money = money;
	}
	
	//HashCode Equals
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
		Client other = (Client) obj;
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


	//Methods
	protected Cake getRandomCake(SweetShop s) {
		int randomCake = new Random().nextInt(s.getAllCakes().size());
		int num = 0;
		for (Cake c : s.getAllCakes()) {
			if(randomCake == num++) {
				return c;
			}
		}
		return null;
	}
	
	public void payCakes(int price, SweetShop s) {
		this.money -= price;
		s.increaseMoney(price);
	}
	
	public abstract void makeOrder(SweetShop s);
	public abstract void giveTip(int price, DeliveryMan dm);
	
	
	public void setMoneyGivenForCakes(int moneyGivenForCakes) {
		this.moneyGivenForCakes = moneyGivenForCakes;
	}
	
	public int getMoneyGivenForCakes() {
		return moneyGivenForCakes;
	}
	
	public String getName() {
		return name;
	}
}
