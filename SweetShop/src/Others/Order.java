package Others;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import cakes.Cake;
import clients.Client;

public class Order {
	private Client client;
	private int price;
	private String address;
	private ArrayList<Cake> cakes;
	private DeliveryMan deliveryMan;
	private LocalDateTime dateTime;
	
	public Order(Client client, int price, String address, ArrayList<Cake> cakes, DeliveryMan deliveryMan) {
		super();
		this.client = client;
		this.price = price;
		this.address = address;
		this.cakes = cakes;
		this.deliveryMan = deliveryMan;
		this.dateTime = LocalDateTime.now();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
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
		Order other = (Order) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}

	
	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}
	
	public Client getClient() {
		return client;
	}
	
	public int getPrice() {
		return price;
	}
}
