package Others;

import java.util.HashSet;

public class DeliveryMan {
	private String name;
	private String tel;
	private double money;
	private int deliveredOrders;
	private HashSet<Order> orders;
	
	public DeliveryMan(String name, String tel) {
		super();
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
		DeliveryMan other = (DeliveryMan) obj;
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

	public void takeTip(double tip) {
		this.money += tip;
		
	}
	
	public void deliver(Order o, SweetShop s) {
		o.getClient().giveTip(o.getPrice(), o.getDeliveryMan());
		o.getClient().payCakes(o.getPrice(), s);
		deliveredOrders++;
		
	}
	
	public double getMoney() {
		return money;
	}
	
	public int getDeliveredOrders() {
		return deliveredOrders;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " : " + this.money;
	}
	
}
